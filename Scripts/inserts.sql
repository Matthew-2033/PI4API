USE hugolutke01;

-- Insert de Roles:
insert into User(ID_User, Username)
	values('4ad7924a-7f84-11e9-9499-005056a34071', 'GabrielCarmo');
insert into User(ID_User, Username)
	values('6380603d-7f84-11e9-9499-005056a34071', 'Matheus');    
insert into User(ID_User, Username)
	values('65f53ddf-7f84-11e9-9499-005056a34071', 'Casio');    
insert into User(ID_User, Username)
	values('68659525-7f84-11e9-9499-005056a34071', 'Lucas');    

insert into Role(Role_ID, Role)
	values('2190b649-7f85-11e9-9499-005056a34071', 'admin');  
insert into User_Role(Id_User_Role, ID_User, Role_ID)
	values(uuid(), '4ad7924a-7f84-11e9-9499-005056a34071', '2190b649-7f85-11e9-9499-005056a34071'); 
insert into User_Role(Id_User_Role, ID_User, Role_ID)
	values(uuid(), '6380603d-7f84-11e9-9499-005056a34071', '2190b649-7f85-11e9-9499-005056a34071'); 
insert into User_Role(Id_User_Role, ID_User, Role_ID)
	values(uuid(), '65f53ddf-7f84-11e9-9499-005056a34071', '2190b649-7f85-11e9-9499-005056a34071'); 
insert into User_Role(Id_User_Role, ID_User, Role_ID)
	values(uuid(), '68659525-7f84-11e9-9499-005056a34071', '2190b649-7f85-11e9-9499-005056a34071'); 
    
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



