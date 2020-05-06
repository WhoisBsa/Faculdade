create database escola;

use escola;

create table aluno (
	id 		int primary key auto_increment,
    nome	varchar(50),
    idade	varchar(50),
    faltas	varchar(50),
    nota	varchar(50)
);


insert into aluno(nome, idade, faltas, nota) values('Matheus', '20', '0', '29');

select * from aluno;