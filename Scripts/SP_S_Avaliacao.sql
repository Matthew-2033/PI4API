DELIMITER $$ 
CREATE PROCEDURE SP_S_Avaliacao
(
	IN avaliado_id INT
)
BEGIN
	IF avaliado_id IS NOT NULL
	THEN
		SELECT 
			AVC.Avaliacao_id,
			AVC.idade,
			AVC.massa,
			AVC.estatura,
			AVC.peitoral,
			AVC.auxiliar_media,
			AVC.sub_escapular,
			AVC.tricipital,
			AVC.biciptal,
			AVC.supra_iliaca,
			AVC.coxa,
			AVC.panturrilha,
			AVC.torax,
			AVC.braco_direito,
			AVC.braco_esquerdo,
			AVC.antebraco_direito,
			AVC.antebraco_esquerdo,
			AVC.abdominal,
			AVC.cintura,
			AVC.quadril,
			AVC.coxa_direita,
			AVC.coxa_esquerda,
			AVC.perna_direita,
			AVC.perna_esquerda,
			AVC.imc,
			AVC.pccg,
			AVC.peso_atual,
			AVC.massa_de_gordura,
			AVC.massa_magra,
			AVC.peso_ideal,
			AVC.peso_em_excesso
		FROM hugolutke01.Avaliacao AS AVC
			WHERE AVC.avaliado_id = avaliado_id;	
	
    ELSE
		SELECT 
			AVC.Avaliacao_id,
			AVC.idade,
			AVC.massa,
			AVC.estatura,
			AVC.peitoral,
			AVC.auxiliar_media,
			AVC.sub_escapular,
			AVC.tricipital,
			AVC.biciptal,
			AVC.supra_iliaca,
			AVC.coxa,
			AVC.panturrilha,
			AVC.torax,
			AVC.braco_direito,
			AVC.braco_esquerdo,
			AVC.antebraco_direito,
			AVC.antebraco_esquerdo,
			AVC.abdominal,
			AVC.cintura,
			AVC.quadril,
			AVC.coxa_direita,
			AVC.coxa_esquerda,
			AVC.perna_direita,
			AVC.perna_esquerda,
			AVC.imc,
			AVC.pccg,
			AVC.peso_atual,
			AVC.massa_de_gordura,
			AVC.massa_magra,
			AVC.peso_ideal,
			AVC.peso_em_excesso
		FROM hugolutke01.Avaliacao AS AVC;
	END IF;
END $$
DELIMITER ;