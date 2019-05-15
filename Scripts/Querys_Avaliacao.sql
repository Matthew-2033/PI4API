/* Query Para retornar todos os parametros possiveis referentes a Avaliacao */ 
SELECT 
	  al.id_aluno AS ID_ALUNO
      , av.id_avaliacao AS ID_AVALIACAO
      , info.id_info AS ID_INFO
      , rg.id_resultado_gerais AS ID_RESULTADO_GERAIS
      , ig.id_gordura AS ID_GORDURA, dc.id_corporal AS ID_CORPORAL
      , info.idade AS IDADE 
      , info.massa AS MASSA 
      , info.estatura AS ESTATURA 
      , info.peitoral AS PEITORAL 
      , info.auxiliar_media AS AUXILIAR_MEDIA
	  , info.sub_escapular AS SUB_ESCAPULAR 
      , info.tricipital AS TRICIPITAL
      , info.biciptal AS BICIPTAL 
      , info.supra_iliaca AS SUPRA_ILIACA
	  , info.abdominal AS ABDOMINAL 
      , info.coxa AS COXA 
      , info.panturrilha AS PANTURRILHA 
      , info.torax AS TORAX 
      , info.braco_direito AS BRACCO_DIREITO
	  , info.braco_esquerdo AS BRACO_ESQUERDO
      , info.antebraco_direito AS ANTEBRACO_DIREITO 
      , info.antebraco_esquerdo AS ANTEBRACO_ESQUERDO
	  , info.cintura AS CINTURA 
      , info.quadril AS QUADRIL 
      , info.coxa_direita AS COXA_DIREITA 
      , info.coxa_esquerda AS COXA_ESQUERDA
	  , info.perna_direita AS PERNA_DIREITA 
      , info.perna_esquerda AS PERNA_ESQUERDA
      , rg.imc AS IMC
      , rg.pccg AS PCCG
      , rg.peso_atual AS PESO_ATUAL
      , rg.massa_de_gordura AS MASSA_GORDURA
      , rg.massa_magra AS MASSA_MAGRA
      , rg.peso_ideal AS PESO_IDEAL
      , rg.peso_em_excesso AS PESO_EXCESSO
      , ig.gordura AS GORDURA
      , dc.densidade AS DENSIDADE      
 FROM avaliacao1 av
	INNER JOIN aluno al using(id_aluno)
    INNER JOIN informacoes info using(id_info)
	INNER JOIN resultado_gerais rg using(id_resultado_gerais)
    INNER JOIN indice_Gordura ig using(id_gordura)
    INNER JOIN densidade_corporal dc using(id_corporal);


    
SELECT * FROM resultado_gerais;
SELECT * FROM indice_Gordura;
SELECT * FROM densidade_corporal;
SELECT * FROM tipo;
SELECT * FROM avaliacao1;
