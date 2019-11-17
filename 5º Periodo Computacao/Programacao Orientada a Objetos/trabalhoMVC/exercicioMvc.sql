create database exercicioMvc

use exercicioMvc;

create table paciente(
	id		int primary key auto_increment,
    nome	varchar(50),
    cpf 	varchar(50),
    idade	int,
    genero	enum('M', 'F')
);

create table consulta(
	id				int primary key auto_increment,
	data 			date,
    paciente_id		int,
    constraint fk_PacienteID foreign key (paciente_id) references paciente(id) 
);


insert into paciente(nome, cpf, idade, genero) values('matheus', '11122233344', 19, 'M');
insert into consulta(data, paciente_id) values('2019/11/11', 1);
insert into paciente(nome, cpf, idade, genero) values ('joaquim', '123.123.123-12', 30, 'M');
insert into consulta(data, paciente_id) values ('2019/11/10', 2);
insert into consulta(data, paciente_id) values ('2019/11/11', 2);
insert into consulta(data, paciente_id) values ('2019/12/30', 3);
insert into consulta(data, paciente_id) values ('2020/01/01', 3);
insert into consulta(data, paciente_id) values ('2019/11/25', 2);
insert into consulta(data, paciente_id) values ('2019/11/29', 4);
insert into consulta(data, paciente_id) values ('2019/12/23', 1);
insert into consulta(data, paciente_id) values ('2019/12/10', 2);
insert into consulta(data, paciente_id) values ('2019/11/11', 4);
insert into consulta(data, paciente_id) values ('2019/11/29', 2);


select * from paciente;
select * from consulta;


select * from paciente inner join consulta on paciente.id = consulta.paciente_id where consulta.id = 2;
select * from paciente inner join consulta on paciente.id = consulta.paciente_id where paciente.id = 2;

