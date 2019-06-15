delimiter $$
CREATE PROCEDURE sp_select_avaliado_sem_avaliacao()
BEGIN
	SELECT 
		AL.id_aluno as id,
		AL.nome as nome,
		AL.data_nascimento as dataNascimento,
		if(AL.sexo = "M", 1, if(AL.sexo = "F", 2, 3)) as sexo,
		AV.data_avaliacao AS ultimaAvaliacao,
		AL.email as email,
		AL.CPF as cpf,
		AL.ativo as ativo
	FROM hugolutke01.aluno AS AL
	LEFT JOIN hugolutke01.avaliacao2 AS AV USING(id_aluno)
	WHERE AL.id_aluno NOT IN ( SELECT id_aluno FROM avaliacao2 );
END $$
delimiter ;

CALL SP_S_Avaliado(NULL);