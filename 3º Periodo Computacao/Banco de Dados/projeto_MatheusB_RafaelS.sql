CREATE DATABASE PROJETOS;

CREATE SCHEMA projetos;

create table PROJETOS.funcionario(
	idmatfun		varchar(10)		not null,
    nmfun			varchar(20)		not null,
    cdsexo			char			not null,
    dtalocdepat		date			not null,
    iddep			int				not null,
    idcargo			varchar(20)		not null,
    cdcep			varchar(9)		not null,
    nulogradouro	varchar(30)		not null,
    encomple		varchar(15)		not null,
    datanasc		date			not null,
    idmatgeren		varchar(10)		not null,
    idmatfundepen	varchar(10)		not null,
    idmarfuncoor	varchar(10)		not null,
    idmatfuncinst	varchar(10)		not null,
    primary key (idmatfun),
    foreign key (idmatgeren) references funcionario(idmatgeren),
    foreign key (iddep) references departamento(iddep),
	foreign key (idcargo) references cargo(idcargo), 
	foreign key (cdcep) references cep(cdcep));
    
create table PROJETOS.departamento(
	iddep			int 			not null,
    iddiret			int				not null,
    nmdep			varchar(20)		not null,
    datacri			date			not null,
    codfungere		varchar(10)		not null,
    primary key (idddep),
    foreign key (iddiret) references diretoria(iddiret),
    foreign key (codfungere) references funcionario(idmategeren));

create table PROJETOS.cargo(
	idcargo			varchar(20)		not null,
    nmcargo			varchar(20)		not null,
    primary key (idcargo));

create table PROJETOS.cep(
    cdcep			varchar(9)		not null,
	nulogradouro	varchar(30)		not null,
	cdmuni			int				not null,
    primary key (cdcep));
    
create table PROJETOS.diretoria(
	iddiret			int				not null,
	cdfuncd			varchar(10)		not null,
    primary key (iddiret),
    foreign key (codfuncd) references departamento(idmatgeren));
    
create table PROJETOS.sessao(
	idses			int				not null,
    iddep			int				not null,
    codfuncc		varchar(10)		not null,
    primary key (idses),
    foreign key (iddep) references departamento(iddep),
    foreign key (codfuncc) references funcionario(idmatfuncoor));

create table PROJETOS.funcao(
	idfuncao		int 			not null,
	nmfuncao		varchar(20)		not null,
    primary key (idfncao));
    
create table PROJETOS.funcfuncao(
	idmatfun		varchar(10)		not null,
	idfuncao		int 			not null,
	primary key (idmatfun, idfuncao),
    foreign key (idmatfun) references funcionario(idmatfun),
    foreign key (idfuncao) references funcao(idfuncao));
    
create table PROJETOS.idioma(
	ididioma 		int 		not null,
    nmidioma		varchar(15)	not null,
    primary key (ididioma));
    
create table PROJETOS.funcidioma(
	idmatfun		varchar(10)		not null,
	ididioma 		int 		not null,
    primary key (idmatfun, ididioma),
	foreign key (idmatfun) references funcionario(idmatfun),
	foreign key (ididioma) references idioma(ididioma));

create table PROJETOS.functel(
	idmatfun		varchar(10)		not null,
	numtel			varchar(10)		not null,
    codtipotel		varchar(10)		not null,
    primary key (idmatfun, numtel),
	foreign key (idmatfun) references funcionario(idmatfun));
    
create table PROJETOS.dependente(
	idmatfun		varchar(10)		not null,
	numdepen		int 			not null,
    idmatfundepen	varchar(10)		not null,
    nmdepen			varchar(20),
    dtnascdep		date,
    primary key (idmatfun, numdepen),
	foreign key (idmatfun, idmatfundepen) references funcionario(idmatfun, idmatfundepen));

create table PROJETOS.projeto(
	idproj			int				not null,
    nmproj			varchar(20)		not null,
    qhrprevis		decimal(2,2)		not null,
    qhrgasta		decimal(2,2)		not null,
    primary key (idproj));

create table PROJETOS.reservaequipe(
	idproj			int				not null,
	idmatfun		varchar(10)		not null,
	dtaloc			date 			not null,
    primary key (idproj, idmatfun),
    foreign key (idproj) references projeto(idproj),
	foreign key (idmatfun) references funcionario(idmatfun));

create table PROJETOS.atividades(
	idatvdd			int 			not null,
    nmatvdd			varchar(20)		not null,
    primary key (idatvdd));

create table PROJETOS.compprojeto(
	idproj			int				not null,
	idatvdd			int 			not null,
	primary key (idproj, idatvdd),
    foreign key (idproj) references projeto(idproj),
	foreign key (idatvdd) references atividades(idatvdd));

create table PROJETOS.esforcoproj(
	idproj			int				not null,
	idatvdd			int 			not null,
	idmatfun		varchar(10)		not null,
    qhrgasta		decimal(2,2)	not null,
	primary key (idproj, idatvdd, idmatfun),
	foreign key (idproj) references projeto(idproj),
	foreign key (idatvdd) references atividades(idatvdd)
	foreign key (idmatfun) references funcionario(idmatfun));

create table PROJETOS.curso(
	idcurso			int 			not null,
    nmcurso			varchar(20)		not null,
	cdfuncinst		varchar(10)		not null,
    primary key (idcurso),
    foreign key (cdfuncinst) references funcionario(idmatfuninst));

create table PROJETOS.projtreinamentocurso(
	idproj			int				not null,
	idcurso			int 			not null,
    primary key (idproj, idcurso),
	foreign key (idproj) references projeto(idproj),
	foreign key (idcurso) references curso(idcurso));

create table PROJETOS.projtrei(
	idproj			int				not null,
	tptrei			varchar(20)		not null,
	primary key (idproj),
	foreign key (idproj) references projeto(idproj));

create table PROJETOS.projsoft(
	idproj			int				not null,
	cdtpmetod		int 			not null,
	primary key (idproj),
	foreign key (idproj) references projeto(idproj));

create table PROJETOS.projconsult(
	idproj			int				not null,
	primary key (idproj),
	foreign key (idproj) references projeto(idproj));


