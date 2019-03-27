USE hugolutke01;

-- Insert de Roles:
insert into User(Username, Password)
	values('GabrielCarmo', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92');
insert into User(Username, Password)
	values('Matheus', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92');    
insert into User(Username, Password)
	values('Casio', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92');    
insert into User(Username, Password)
	values('Lucas', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92');    

insert into Role(Role)
	values('admin');  
insert into User_Role(ID_User, Role_ID)
	values(1, 1); 
insert into User_Role(ID_User, Role_ID)
	values(2, 1); 
insert into User_Role(ID_User, Role_ID)
	values(3, 1); 
insert into User_Role(ID_User, Role_ID)
	values(4, 1); 
    
-- Insert de Avaliados:
insert into Avaliado (nome, data_nascimento, sexo, email, CPF) values ('Matheus', '1999/05/25', 1, 'matheus-a.g@hotmail.com', '123456789');
insert into Avaliado (nome, data_nascimento, sexo, email, CPF) values ('Gabriel', '1999/08/25', 1, 'gabriel@hotmail.com', '456789132');
insert into Avaliado (nome, data_nascimento, sexo, email, CPF) values ('Cassio', '1999/05/25', 1, 'cassio@hotmail.com', '19842498');

select * from Avaliado;				
select * from Avaliacao join Avaliado on Avaliado.avaliado_id = Avaliacao.avaliado_id where Avaliado.avaliado_id = 3;

-- Query utilizada no update do Aluno
UPDATE Avaliado SET 
	nome = "Matheus",
	data_nascimento = "1999-05-25",
	sexo = 2,
	email = "matheus-a.g@hotmail.com",
	CPF = "123456789",
	ativo = 1 
WHERE avaliado_id = 5;



