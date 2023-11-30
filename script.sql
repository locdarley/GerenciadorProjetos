-- Criação da tabela de Usuario
CREATE TABLE Usuario (
    id serial PRIMARY KEY,
    NomeUsuario VARCHAR(255) NOT NULL,
    Senha VARCHAR(255) NOT NULL,
    NivelAcesso VARCHAR(10) NOT NULL
);

-- Criação da tabela de Projeto
CREATE TABLE Projeto (
    id serial PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    Descricao TEXT,
    DataInicio DATE NOT NULL,
    Responsavel INT NOT NULL,  -- Chave estrangeira para o ID do Usuario
    FOREIGN KEY (Responsavel) REFERENCES Usuario(ID)
);


ALTER TABLE Projeto
ALTER COLUMN DataInicio TYPE VARCHAR(255);

-- Criação da tabela de Requisito
CREATE TABLE Requisito (
    id serial PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    Descricao TEXT,
    Prioridade VARCHAR(45) NOT NULL,
    Complexidade VARCHAR(45) NOT NULL,
    ProjetoID INT NOT NULL,  -- Chave estrangeira para o ID do Projeto
    FOREIGN KEY (ProjetoID) REFERENCES Projeto(ID)
);

select * from usuario
select * from projeto
select * from requisito


INSERT INTO Projeto (Nome, Descricao, DataInicio, Responsavel)
VALUES ('Projeto do Darley', 'um projeto qualquer', '2023-11-21', 8);