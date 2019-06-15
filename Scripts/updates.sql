UPDATE avaliacao SET 
	  massa = ?
    , estatura = ?
    , imc = ?
    , pccg = ?
    , massa_de_gordura = ?
    , massa_magra = ?
    , peso_ideal = ?
    , peso_em_excesso = ?
WHERE id_avaliacao = ?;

UPDATE avaliacaoDobras SET 
	  peitoral = ?
	 ,auxiliar_media = ?
	 ,sub_escapular = ?
	 ,tricipital = ?
	 ,biciptal = ?
	 ,supra_iliaca = ?
	 ,abdominal = ?
	 ,coxa = ?
	 ,panturrilha = ?
WHERE id_avaliacao = ?;

UPDATE avaliacaoPerimetro SET
	 torax = ? 
	,braco_direito = ? 
	,braco_esquerdo = ? 
	,antebraco_direito = ? 
	,antebraco_esquerdo = ? 
	,abdominal = ? 
	,cintura = ? 
	,quadril = ? 
	,coxa_direita = ? 
	,coxa_esquerda = ? 
	,perna_direita = ? 
	,perna_esquerda = ? 
WHERE id_avaliacao = ?;

UPDATE avaliacaoPorcentagemGordura SET 
	 porcentagemGordura = ?
	,autor = ?
WHERE id_avaliacao = ? AND autor = ?;

