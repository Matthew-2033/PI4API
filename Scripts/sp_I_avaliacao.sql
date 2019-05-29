/*
delimiter $$
CREATE PROCEDURE sp_I_avaliacao
(
	IN ID_avaliacao CHAR(36),
	IN ID_aluno CHAR(36),
	IN massa DECIMAL(11,7), 
	IN estatura DECIMAL(11,7),
    IN imc DECIMAL(11,7),
    IN pccq DECIMAL(11,7),
    IN massaDeGordura DECIMAL(11,7),
    IN massaMagra DECIMAL(11,7),
    IN pesoIdeal DECIMAL(11,7),
    IN pesoEmExcesso DECIMAL(11,7)
)
BEGIN

	DECLARE id_avaliacao_inserido CHAR(36);
    DECLARE idAlunoAvaliacao CHAR(36);
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION    
	
	INSERT INTO avaliacao 
    (
		 id_avaliacao
        ,massa
        ,estatura
        ,imc
        ,pccg
        ,massa_de_gordura
        ,massa_magra
        ,peso_ideal
        ,peso_em_excesso  
	) 
    VALUES
    (
		 idAvaliacao
        ,massa
        ,estatura
        ,imc
        ,pccg
        ,massa_de_gordura
        ,massa_magra
        ,peso_ideal
        ,peso_em_excesso
	);
	
	SET id_avaliacao_inserido = (SELECT id_avaliacao FROM avaliacao WHERE id_avaliacao = idAvaliacao);
	
	IF id_avaliacao_inserido IS NOT NULL 
    THEN 
		
        SET idAlunoAvaliacao = uuid();
		INSERT INTO alunoAvaliacao 
		( 
			 id_alunoAvaliacao
			,id_aluno
			,id_avaliacao
		) 
		VALUE 
		( 
			 idAlunoAvaliacao
			,ID_aluno
            ,ID_avaliacao
		);				
              
	END IF; 
    
	SELECT IFF(COUNT(*) = 1, TRUE, FALSE) sucesso FROM alunoAvaliacao WHERE id_alunoAvaliacao = idAlunoAvaliacao;		
END$$
delimiter ;
*/
/*
drop PROCEDURE sp_add_avaliacao;
CALL sp_add_avaliacao();
select * from avaliacao;
*/

CALL sp_I_avaliacao(uuid(), '5de0574c-1f18-44be-984a-05bd4f825f3f', 1, 2, 3, 4, 5, 6, 7, 8);