create database BANCO;

create table BANCO.banco(
	codigo		int			not null		primary key,
    nome		varchar(20)	not null
);

create table BANCO.agencia(
	num_agencia		int		not null,
    endereco		varchar(30)		not null,
    cod_banco		int				not null,
    primary key (num_agencia,cod_banco),
    foreign key (cod_banco)	references banco(codigo)
);

create table BANCO.cliente(
	cpf 		varchar(11)		not null 	primary key,
    nome		varchar(20)		not null,
    sexo		char			not null,
	endereco	varchar(30)		not null
);

create table BANCO.conta(
	num_conta		varchar(7)		not null		primary key,
    saldo			float	not null,
    tipo_conta		int				not null,
	num_agencia		int				not null,
    cod_banco		int				not null,
    foreign key (num_agencia,cod_banco) references agencia(num_agencia,cod_banco)
);
    
create table BANCO.historico(
	cpf_cliente 	varchar(11)		not null,
    num_conta		varchar(7)		not null,
    data_inicio		date			not null,
    primary key (cpf_cliente,num_conta),
    foreign key (cpf_cliente) references cliente(cpf),
    foreign key (num_conta) references conta(num_conta)
);

create table tel_cliente(
	cpf_cli		varchar(11)		not null 	primary key,
    telefone	varchar(13)		not null
);
