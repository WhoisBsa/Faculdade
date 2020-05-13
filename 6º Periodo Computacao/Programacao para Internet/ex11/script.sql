CREATE DATABASE locadora;

USE locadora;

CREATE TABLE filmes(
	id		int	primary key auto_increment,
    nome	varchar(50),
    ano 	varchar(50),
    duracao	varchar(50),
    genero	varchar(50)
);

DESCRIBE filmes;

INSERT INTO filmes(nome, ano, duracao, genero) VALUES ('Donnie Darko', '2001', '108', 'Fantasia');

SELECT * FROM filmes;