DELIMITER $$ 
CREATE PROCEDURE SP_S_Avaliado
(
	IN avaliado_id INT
)
BEGIN
	IF avaliado_id IS NOT NULL
	THEN
		SELECT 
			AV.avaliado_id as id,
			AV.nome as nome,
			AV.data_nascimento as dataNascimento,
			if(AV.sexo = "M", 1, if(AV.sexo = "F", 2, 3)) as sexo,
			AV.email as email,
			AV.CPF as cpf,
			AV.ativo as ativo
		FROM hugolutke01.Avaliado AS AV
		WHERE AV.avaliado_id = avaliado_id;	
	
    ELSE
		SELECT 
			AV.avaliado_id as id,
			AV.nome as nome,
			AV.data_nascimento as dataNascimento,
			if(AV.sexo = "M", 1, if(AV.sexo = "F", 2, 3)) as sexo,
			AV.email as email,
			AV.CPF as cpf,
			AV.ativo as ativo
		FROM hugolutke01.Avaliado AS AV;
	END IF;
END$$
DELIMITER ;
