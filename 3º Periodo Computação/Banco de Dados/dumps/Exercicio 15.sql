create database EMPRESA;

create table empresa(
	cnpj 		varchar(20) 	not null,
	ie			varchar(20)		not null,
	razaos		varchar(300),
	nome		varchar(300)	not null,
	endloga		varchar(300),
	endnum		int,
	endbair		varchar(300),
	endcid		varchar(300),
	endest		varchar(300),
	endcep		varchar(10),
	primary key (cnpj));

create table funcionario(
	cpf 		varchar(20)		not null,
	nome		varchar(300),
	rg			varchar(20),
	endloga		varchar(300),
	endbair		varchar(300),
	endcid		varchar(300),
	endest		varchar(300),
	endcep		varchar(10),
	dataemis	date,
	ncarteirat	varchar(45),
	primary key (cpf));

create table caixa(
	idcaixa int not null primary key,
	descri	varhcar(500));

create table func_caixa(
	idfunc		int				not null,
	func_cpf	varchar(20),
	idcaixa		int,
	dataaber	date,
	horaaber	time,
	valoraber	int,
	datafech	date,
	hrfech		time,
	valorfech	int,
	primary key (idfunc),
	foreign key (func_cpf) references funcionario(cpf),
	foreign key (idcaixa) references caixa(idcaixa));

create table cupom(
	ccf 		int 	not null,
	data 		date,
	hora		time,
	valortt		int,
	emp_cnpj	varchar(20),
	fcidfc		int,
	primary key (ccf),
	foreign key (emp_cnpj) references empresa(cnpj),
	foreign key (fcidfc) references func_caixa(idfunc));

create table produto(
	idprod		int		not null,
	nome 		varchar(20),
	descri		varchar(300),
	unidade		varchar(45),
	precouni	int,
	primary key (idprod));

create table itemcf(
	cupomfccf	int		not null,
	idprod		int,
	item 		int,
	qtd			varchar(45),
	valoritem	varchar(45),
	primary key (cupomfccf, idprod, item));