USE hugolutke01;

CREATE TABLE User 
(
	ID_User CHAR(36) UNIQUE NOT NULL PRIMARY KEY,
    Username VARCHAR(100) UNIQUE NOT NULL,
    Password VARCHAR(200) NOT NULL DEFAULT '$2a$10$qFFRrYmbeAjL/j7Jd0Qr.u.qWlvh5U1jumvqKSU2jXb1e7MJsPmTW',
    Data_Criacao DATETIME NOT NULL,
    Ultimo_Acesso DATETIME NULL,
    Senha_Redefinida BOOLEAN DEFAULT TRUE
);

CREATE TRIGGER user_OnInsert BEFORE INSERT ON User
    FOR EACH ROW SET NEW.Data_Criacao = IFNULL(NEW.Data_Criacao, NOW());

CREATE TABLE Role
(
	Role_ID CHAR(36) UNIQUE NOT NULL PRIMARY KEY,
	Role VARCHAR(25)
);

CREATE TABLE User_Role
(
	Id_User_Role CHAR(36) UNIQUE NOT NULL PRIMARY KEY,
    ID_user CHAR(36) NOT NULL,
    Role_ID CHAR(36) NOT NULL,
    
    CONSTRAINT FK_ID_User FOREIGN KEY(ID_User)
		REFERENCES User(ID_User),
    CONSTRAINT FK_Role_ID FOREIGN KEY(Role_ID)
		REFERENCES Role(Role_ID)        
);

-- Tables para Realizar a avaliação física:
CREATE TABLE aluno
(
	id_aluno CHAR(36) UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo ENUM('F','M') NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    CPF VARCHAR(15) NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    dataInclusao DATETIME NOT NULL
);

CREATE TRIGGER aluno_OnInsert BEFORE INSERT ON aluno
    FOR EACH ROW SET NEW.dataInclusao = IFNULL(NEW.dataInclusao, NOW());

CREATE TABLE avaliacao
(
	id_avaliacao CHAR(36) UNIQUE NOT NULL PRIMARY KEY,
    dataAvaliacao DATETIME NOT NULL,
	massa DECIMAL(5,5) NULL,
	estatura DECIMAL(5,5) NULL,    
    imc DECIMAL(5,5) null,
    pccg DECIMAL(5,5) null,
    massa_de_gordura DECIMAL(5,5) null,
    massa_magra DECIMAL(5,5) null,
    peso_ideal DECIMAL(5,5) null,
    peso_em_excesso DECIMAL(5,5) null
);

CREATE TRIGGER avaliacao_OnInsert BEFORE INSERT ON avaliacao
    FOR EACH ROW SET NEW.dataAvaliacao = IFNULL(NEW.dataAvaliacao, NOW());


CREATE TABLE alunoAvaliacao
(
	id_alunoAvaliacao CHAR(36) UNIQUE NOT NULL PRIMARY KEY,
    id_aluno CHAR(36) NOT NULL,
    id_avaliacao CHAR(36) NOT NULL,
    
    CONSTRAINT alunoAvaliacao_aluno FOREIGN KEY (id_aluno)
		REFERENCES aluno(id_aluno),
	CONSTRAINT alunoAvaliacao_avaliacao FOREIGN KEY (id_avaliacao)
		REFERENCES avaliacao(id_avaliacao)
);

CREATE TABLE avaliacaoDobras
(
	id_avaliacaoDobras CHAR(36) UNIQUE NOT NULL PRIMARY KEY,
    id_avaliacao CHAR(36) NOT NULL,
	peitoral DECIMAL(5,5) NULL,
	auxiliar_media DECIMAL(5,5) NULL,
	sub_escapular DECIMAL(5,5) NULL,
	tricipital DECIMAL(5,5) NULL,
	biciptal DECIMAL(5,5) NULL,
	supra_iliaca DECIMAL(5,5) NULL,
	abdominal DECIMAL(5,5) NULL,
	coxa DECIMAL(5,5) NULL,
	panturrilha DECIMAL(5,5) NULL,
    
	CONSTRAINT avaliacaoDobras_avaliacao FOREIGN KEY (id_avaliacao)
		REFERENCES avaliacao(id_avaliacao)
);

CREATE TABLE avaliacaoPerimetro
(
	id_avaliacaoPerimetro CHAR(36) UNIQUE NOT NULL PRIMARY KEY,
    id_avaliacao CHAR(36) NOT NULL,
	torax DECIMAL(5,5) NULL,
	braco_direito DECIMAL(5,5) NULL,
	braco_esquerdo DECIMAL(5,5) NULL,
	antebraco_direito DECIMAL(5,5) NULL,
	antebraco_esquerdo DECIMAL(5,5) NULL,
    abdominal DECIMAL(5,5) NULL,
	cintura DECIMAL(5,5) NULL,
	quadril DECIMAL(5,5) NULL,
	coxa_direita DECIMAL(5,5) NULL,
	coxa_esquerda DECIMAL(5,5) NULL,
	perna_direita DECIMAL(5,5) NULL,
	perna_esquerda DECIMAL(5,5) NULL,
    
    CONSTRAINT avaliacaoPerimetro_avaliacao FOREIGN KEY (id_avaliacao)
		REFERENCES avaliacao(id_avaliacao)
);

CREATE TABLE avaliacaoPorcentagemGordura
(
	id_avaliacaoPorcentagemGordura CHAR(36) UNIQUE NOT NULL PRIMARY KEY,
    id_avaliacao CHAR(36) NOT NULL,
    porcentagemGordura DECIMAL(5,5) NOT NULL,
    autor VARCHAR(20) NOT NULL,
    
	CONSTRAINT avaliacaoPorcentagemGordura_avaliacao FOREIGN KEY (id_avaliacao)
		REFERENCES avaliacao(id_avaliacao)
);