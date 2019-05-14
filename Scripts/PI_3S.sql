USE hugolutke01;

CREATE TABLE User 
(
	ID_User INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(100) UNIQUE NOT NULL,
    Password VARCHAR(200) NOT NULL DEFAULT '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',
    Data_Criacao DATETIME NOT NULL DEFAULT NOW(),
    Ultimo_Acesso DATETIME NULL,
    Senha_Redefinida BOOLEAN DEFAULT TRUE
);

CREATE TABLE Role
(
	Role_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Role VARCHAR(25)
);

CREATE TABLE User_Role
(
	Id_User_Role INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ID_user INT NOT NULL,
    Role_ID INT NOT NULL,
    
    CONSTRAINT FK_ID_User FOREIGN KEY(ID_User)
		REFERENCES user(ID_User),
    CONSTRAINT FK_Role_ID FOREIGN KEY(Role_ID)
		REFERENCES role(Role_ID)        
);

-- Tables para Realizar a avaliação física:
CREATE TABLE aluno
(
	id_aluno INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo ENUM('F','M') NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    CPF VARCHAR(15) NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);
drop table avaliacao1;
CREATE TABLE avaliacao1
(
	id_avaliacao INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_aluno INT NOT NULL,
    id_info INT NOT NULL,
    id_resultado_gerais INT DEFAULT NULL,
    id_gordura INT DEFAULT NULL,
    id_corporal INT DEFAULT NULL, 
    
    CONSTRAINT avaliacao_aluno FOREIGN KEY (id_aluno)
		REFERENCES aluno(id_aluno),
        
	CONSTRAINT avaliacao_info FOREIGN KEY (id_info)
		REFERENCES informacoes(id_info),
        
	CONSTRAINT avaliacao_resultado_geral FOREIGN KEY (id_resultado_gerais)
		REFERENCES resultado_gerais(id_resultado_gerais),
        
	CONSTRAINT avaliacao_gordura FOREIGN KEY (id_gordura)
		REFERENCES indice_Gordura(id_gordura),
        
	CONSTRAINT avaliacao_densidade_corporal FOREIGN KEY (id_corporal)
		REFERENCES densidade_corporal(id_corporal)
);

CREATE TABLE informacoes(
	
    id_info INT NOT NULL auto_increment primary KEY,
    
	-- Dados do Avaliado
	idade INT NOT NULL,
	massa DECIMAL(4,2) NOT NULL,
    estatura DECIMAL(4,2) NOT NULL,
    
	-- Dobras, unidade de medida em MM
    peitoral DECIMAL(4,2) NOT NULL,
    auxiliar_media DECIMAL(4,2) NOT NULL,
    sub_escapular DECIMAL(4,2) NOT NULL,
    tricipital DECIMAL(4,2)NOT NULL,
    biciptal DECIMAL(4,2) NOT NULL,
    supra_iliaca DECIMAL(4,2) NOT NULL,
    abdominal DECIMAL(4,2) NOT NULL,
    coxa DECIMAL(4,2) NOT NULL,
    panturrilha DECIMAL(4,2) NOT NULL,
    
    -- Perimetros, Unidade de medida em Cm
    torax DECIMAL(4,2) NOT NULL,
    braco_direito DECIMAL(4,2) NOT NULL,
    braco_esquerdo DECIMAL(4,2) NOT NULL,
    antebraco_direito DECIMAL(4,2) NOT NULL,
    antebraco_esquerdo DECIMAL(4,2) NOT NULL,
    cintura DECIMAL(4,2) NOT NULL,
    quadril DECIMAL(4,2) NOT NULL,
    coxa_direita DECIMAL(4,2) NOT NULL,
    coxa_esquerda DECIMAL(4,2) NOT NULL,
    perna_direita DECIMAL(4,2) NOT NULL,
    perna_esquerda DECIMAL(4,2) NOT NULL
);

CREATE TABLE resultado_gerais
(
	id_resultado_gerais INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    imc DECIMAL(4,2) NOT NULL,
    pccg DECIMAL(4,2) NOT NULL,
    peso_atual DECIMAL(4,2) NOT NULL,
    massa_de_gordura DECIMAL(4,2) NOT NULL,
    massa_magra DECIMAL(4,2) NOT NULL,
    peso_ideal DECIMAL(4,2) NOT NULL,
    peso_em_excesso DECIMAL(4,2) NOT NULL
);

CREATE TABLE tipo
(
	id_tipo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL
);

CREATE TABLE indice_Gordura
(	
    id_gordura INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_tipo INT NOT NULL,
    gordura DOUBLE NOT NULL,
    
    CONSTRAINT tipo_gordura FOREIGN KEY(id_tipo)
		REFERENCES tipo(id_tipo)
);

CREATE TABLE densidade_corporal
(
	id_corporal INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_tipo INT NOT NULL,
    densidade DOUBLE NOT NULL,
    
	CONSTRAINT tipo_densidade_corporal FOREIGN KEY (id_tipo)
		REFERENCES tipo(id_tipo)
);

