create database trab2;
use trab2;

create table alunos(
	id int primary key auto_increment,
	nome varchar(255) not null, 
    sexo ENUM('F','M') not null,
    nascimento date not null
);
/* DADOS TRASNFERIDOS PARA A TABELA ALUNOS ATRAVÉS DO IMPORT WIZARD PROVIDO PELO WORKBENCH,
   DADOS CSV ANEXADOS AO .RAR ENTREGUE JUNTO DESSE SCRIPT*/	

DROP PROCEDURE IF EXISTS SP_HOMONIMOS;
CALL SP_HOMONIMOS();
DELIMITER $$
CREATE PROCEDURE SP_HOMONIMOS()
BEGIN
    	
	DECLARE nome_buscado VARCHAR(250);        
	DECLARE parte_do_nome VARCHAR(250);          
	DECLARE length_nomes INT(1);                
    DECLARE contador INTEGER DEFAULT 1;         
	DECLARE finished INTEGER DEFAULT 0; 
    
    DECLARE cursor_homonimo CURSOR FOR
		SELECT nome FROM alunos;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET finished = 1;
     
    DROP TABLE IF EXISTS composicao_nome; 
	DROP TEMPORARY TABLE IF EXISTS output;
    DROP TEMPORARY TABLE IF EXISTS duplicata;
    
    CREATE TEMPORARY TABLE composicao_nome (
		id_composicao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		nome_completo VARCHAR(250) NOT NULL,
        parte VARCHAR(250) NOT NULL
	);
	
    OPEN cursor_homonimo;
		get_nomes: LOOP  
			FETCH cursor_homonimo INTO nome_buscado;  
			
			IF finished = 1 THEN  
				LEAVE get_nomes; 
			END IF; 
			
			select (length(nome) - length(replace(nome, ' ', '')) +1)
				into length_nomes from alunos
			where nome = nome_buscado;
				
			SET contador  = 1;  
			
			WHILE contador <= length_nomes DO  
			
				SET parte_do_nome = SUBSTRING_INDEX(SUBSTRING_INDEX(nome_buscado, ' ', contador ), ' ', -1);

				if char_length(parte_do_nome) > 3 THEN
					INSERT INTO composicao_nome(nome_completo, parte) values (nome_buscado,parte_do_nome);
				end if;
				
				SET contador  = contador  + 1; 
			END WHILE;
		END LOOP get_nomes; 
	CLOSE cursor_homonimo; 
	
	create temporary table duplicata(
		id_composicao INT NOT NULL,
		nome_completo VARCHAR(250) NOT NULL,
        parte VARCHAR(250) NOT NULL
    );
	
    create temporary table output(
		nome_homonimo VARCHAR(250) NOT NULL,
        sexo ENUM('F','M') not null,
        nome_mais_novo VARCHAR(250) NULL,
        sexo_comparacao ENUM('IGUAL', 'DIFERENTE')
    );
    
	insert into duplicata select * from composicao_nome;
    insert into output (nome_homonimo, sexo, nome_mais_novo, sexo_comparacao) 
    SELECT 
		 al.nome,
         al.sexo,
         al2.nome,
         CASE al.sexo WHEN al2.sexo THEN 1 ELSE 2 END COMP
	FROM alunos as al
    LEFT JOIN alunos as al2 on al.nascimento < al2.nascimento
	INNER JOIN (
		SELECT
			  nome.nome_completo
            , nome.parte 
		FROM composicao_nome as nome 
        INNER JOIN duplicata as du on nome.parte = du.parte
         and nome.nome_completo != du.nome_completo
    ) iguais on iguais.nome_completo = al.nome
    ORDER BY iguais.parte, al.nascimento asc , al2.nascimento asc;
	
    select * from output;

	DROP TEMPORARY TABLE IF EXISTS composicao_nome;
	DROP TEMPORARY TABLE IF EXISTS duplicata;
    DROP TEMPORARY TABLE IF EXISTS output;
END $$

