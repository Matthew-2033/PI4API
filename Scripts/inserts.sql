USE PI_3S;

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