delimiter $$
CREATE PROCEDURE sp_add_avaliacao(
in aluno int,
in sp_idade int, in sp_massa decimal(4,2), in sp_estatura decimal(4,2),
in sp_peitoral decimal(4,2), in sp_auxiliar_media decimal(4,2), sp_sub_escapular decimal(4,2),
in sp_tricipital decimal(4,2), in sp_biciptal decimal(4,2), in sp_supra_iliaca decimal(4,2),
in sp_abdominal decimal(4,2),in sp_coxa decimal(4,2), in sp_panturrilha decimal(4,2),
in sp_torax decimal(4,2), sp_braco_direito decimal(4,2), sp_braco_esquerdo decimal(4,2),
in sp_antebraco_direito decimal(4,2), in sp_antebraco_esquerdo decimal(4,2), in sp_cintura decimal(4,2),
in sp_quadril decimal(4,2), in sp_coxa_direita decimal(4,2), in sp_coxa_esquerda decimal(4,2), 
in sp_perna_direita decimal(4,2), in sp_perna_esquerda decimal(4,2))

BEGIN
	DECLARE id_info_inserido int default null;
    
    /* Primeiro adiciona novas informacoes dentro da tabela informacoes */
    INSERT INTO informacoes (
		  idade , massa , estatura , peitoral , auxiliar_media
		, sub_escapular , tricipital , biciptal , supra_iliaca
        , abdominal , coxa , panturrilha, torax , braco_direito
		, braco_esquerdo , antebraco_direito , antebraco_esquerdo
        , cintura , quadril , coxa_direita , coxa_esquerda , perna_direita
        , perna_esquerda
    ) VALUE (
		  sp_idade , sp_massa , sp_estatura , sp_peitoral
		, sp_auxiliar_media , sp_sub_escapular , sp_tricipital
        , sp_biciptal , sp_supra_iliaca , sp_abdominal
        , sp_coxa , sp_panturrilha , sp_torax , sp_braco_direito
        , sp_braco_esquerdo , sp_antebraco_direito, sp_antebraco_esquerdo
        , sp_cintura , sp_quadril , sp_coxa_direita , sp_coxa_esquerda
        , sp_perna_direita , sp_perna_esquerda
    );
    /* Pega o último ID inserido dentro da Avalicao */
    SELECT last_insert_id() INTO id_info_inserido;	
    INSERT INTO avaliacao1 (id_aluno, id_info) values(aluno, id_info_inserido);
    
END$$

CALL sp_add_avaliacao(1,2,3,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
use hugolutke01;
select * from aluno;
select * from avaliacao1;
select * from informacoes;
DROP PROCEDURE sp_add_avaliacao;
select * from avaliacao1 join informacoes using(id_info);
