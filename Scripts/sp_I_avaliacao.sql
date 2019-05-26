delimiter $$
CREATE PROCEDURE sp_I_avaliacao
(
	IN ID_aluno CHAR(36),
	IN massa DECIMAL(4,6), 
	IN estatura DECIMAL(5,6),
	IN peitoral DECIMAL(5,6), 
	IN auxiliar_media DECIMAL(5,6), 
	IN sub_escapular DECIMAL(5,6),
	IN tricipital DECIMAL(5,6), 
	IN biciptal DECIMAL(5,6), 
	IN supra_iliaca DECIMAL(5,6),
	IN abdominal DECIMAL(5,6),
	IN coxa DECIMAL(5,6), 
	IN panturrilha DECIMAL(5,6),
	IN torax DECIMAL(5,6), 
	IN braco_direito DECIMAL(5,6),
	IN braco_esquerdo DECIMAL(5,6),
	IN antebraco_direito DECIMAL(5,6), 
	IN antebraco_esquerdo DECIMAL(5,6), 
	IN cintura DECIMAL(5,6),
	IN quadril DECIMAL(5,6), 
	IN coxa_direita DECIMAL(5,6), 
	IN coxa_esquerda DECIMAL(5,6), 
	IN perna_direita DECIMAL(5,6), 
	IN perna_esquerda DECIMAL(5,6),
    IN imc DECIMAL(5,6),
    IN pccq DECIMAL(5,6),
    IN massaDeGordura DECIMAL(5,6),
    IN massaMagra DECIMAL(5,6),
    IN pesoIdeal DECIMAL(5,6),
    IN pesoEmExcesso DECIMAL(5,6),
    IN porcentagemDeGordura VARCHAR(190)
)
BEGIN
    
	DECLARE id_avaliacao_inserido CHAR(36) DEFAULT NULL;
		
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
		uuid()
        ,1
        ,2
        ,3
        ,4
        ,5
        ,6
        ,7
        ,8
	);
	
	SELECT last_insert_id() INTO id_avaliacao_inserido;		
	
	IF id_avaliacao_inserido IS NOT NULL THEN 
		INSERT INTO informacoes 
		( 
			 id_avaliacao
			,idade 
			,massa 
			,estatura 
			,peitoral 
			,auxiliar_media
			,sub_escapular 
			,tricipital 
			,biciptal 
			,supra_iliaca
			,abdominal 
			,coxa 
			,panturrilha 
			,torax 
			,braco_direito
			,braco_esquerdo 
			,antebraco_direito 
			,antebraco_esquerdo
			,cintura 
			,quadril 
			,coxa_direita 
			,coxa_esquerda 
			,perna_direita
			,perna_esquerda
		) 
		VALUE 
		( 
			 id_avaliacao_inserido
			,idade 
			,massa 
			,estatura 
			,peitoral
			,auxiliar_media 
			,sub_escapular 
			,tricipital
			,biciptal 
			,supra_iliaca 
			,abdominal
			,coxa 
			,panturrilha 
			,torax 
			,braco_direito
			,braco_esquerdo 
			,antebraco_direito
			,antebraco_esquerdo
			,cintura 
			,quadril 
			,coxa_direita 
			,coxa_esquerda
			,perna_direita 
			,perna_esquerda
		);
	END IF; 
END$$
delimiter ;

drop PROCEDURE sp_add_avaliacao;
CALL sp_add_avaliacao(2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);
select * from avaliacao;
