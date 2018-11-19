-- Database: "EMPRESA"

-- DROP DATABASE "EMPRESA";

CREATE DATABASE "EMPRESA"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pt_BR.UTF-8'
       LC_CTYPE = 'pt_BR.UTF-8'
       CONNECTION LIMIT = -1;

-- Schema: empresa

-- DROP SCHEMA empresa;

CREATE SCHEMA empresa
  AUTHORIZATION postgres;

-- Table: empresa.funcionario

-- DROP TABLE empresa.funcionario;

-- Table: empresa.funcionario

-- DROP TABLE empresa.funcionario;

CREATE TABLE empresa.funcionario
(
  pnome character varying(20) NOT NULL,
  minicial character varying(20) NOT NULL,
  uome character varying(20) NOT NULL,
  cpf character varying(11) NOT NULL,
  datanasc date,
  "endereço" character varying(45) NOT NULL,
  sexo character(1) NOT NULL,
  salario numeric(10,2) DEFAULT NULL::numeric,
  cpf_supervisor character varying(11) NOT NULL,
  dnr integer NOT NULL,
  CONSTRAINT fk_funcionario PRIMARY KEY (cpf),
  CONSTRAINT dnr FOREIGN KEY (dnr)
      REFERENCES empresa.departamento (dnumero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE empresa.funcionario
  OWNER TO postgres;

-- Table: empresa.dependente

-- DROP TABLE empresa.dependente;

CREATE TABLE empresa.dependente
(
  fcpf character varying(11) DEFAULT NULL::character varying,
  nome_dependente character varying(20) NOT NULL,
  sexo character(1) NOT NULL,
  datanasc date,
  parentesco character varying(10) DEFAULT NULL::character varying,
  CONSTRAINT fk_dependente PRIMARY KEY (nome_dependente),
  CONSTRAINT dependente_ibfk_1 FOREIGN KEY (fcpf)
      REFERENCES public.funcionario (cpf) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE empresa.dependente
  OWNER TO postgres;
  
-- Table: empresa.departamento

-- DROP TABLE empresa.departamento;

CREATE TABLE empresa.departamento
(
  dnome character varying(20) NOT NULL,
  dnumero integer NOT NULL,
  cpf_gerente character varying(11) NOT NULL,
  data_inicio_gerente date,
  CONSTRAINT fk_departamento PRIMARY KEY (dnumero)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE empresa.departamento
  OWNER TO postgres;

-- Table: empresa.projeto

-- DROP TABLE empresa.projeto;

CREATE TABLE empresa.projeto
(
  projnome character varying(15) NOT NULL,
  projnumero integer NOT NULL,
  projlocal character varying(30) DEFAULT NULL::character varying,
  dnum integer NOT NULL,
  CONSTRAINT fk_projeto PRIMARY KEY (projnumero),
  CONSTRAINT projeto_ibfk_1 FOREIGN KEY (dnum)
      REFERENCES empresa.departamento (dnumero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE empresa.projeto
  OWNER TO postgres;
  
-- Table: empresa.localizacoes_dep

-- DROP TABLE empresa.localizacoes_dep;

CREATE TABLE empresa.localizacoes_dep
(
  dlocal character varying(30) NOT NULL,
  dnumero integer,
  CONSTRAINT fk_localizacoes_dep PRIMARY KEY (dlocal),
  CONSTRAINT localizacoes_dep_ibfk_1 FOREIGN KEY (dnumero)
      REFERENCES empresa.departamento (dnumero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE empresa.localizacoes_dep
  OWNER TO postgres;

-- Table: empresa.trabalha_em

-- DROP TABLE empresa.trabalha_em;

CREATE TABLE empresa.trabalha_em
(
  fcpf character varying(11) NOT NULL,
  pnr integer NOT NULL,
  horas time without time zone NOT NULL,
  CONSTRAINT fk_trabalha_em PRIMARY KEY (fcpf),
  CONSTRAINT trabalha_em_ibfk_1 FOREIGN KEY (fcpf)
      REFERENCES empresa.funcionario (cpf) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT trabalha_em_ibfk_2 FOREIGN KEY (pnr)
      REFERENCES empresa.projeto (projnumero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE empresa.trabalha_em
  OWNER TO postgres;

﻿INSERT INTO EMPRESA.departamento (dnome, dnumero, cpf_gerente, data_inicio_gerente) VALUES ('Pesquisa', 1, 11122233344, '2018-06-17');
INSERT INTO EMPRESA.departamento (dnome, dnumero, cpf_gerente, data_inicio_gerente) VALUES ('Desenvolvimento', 2, 22233344455, '2018-07-17');
INSERT INTO EMPRESA.dependente (fcpf, nome_dependente, sexo, datanasc, parentesco) VALUES (11122277788, 'Matheus', 'M', '1999-12-30', 'Filho');
INSERT INTO EMPRESA.dependente (fcpf, nome_dependente, sexo, datanasc, parentesco) VALUES (33344455566, 'Giulia', 'F', '1999-09-20', 'Filha');
INSERT INTO EMPRESA.funcionario (pnome, minicial, uome, cpf, datanasc, endereço, sexo, salario, cpf_supervisor, dnr) VALUES ('Joao', 'B', 'Souza', 11122277788, '1970-04-05', 'Rua das Dores, 222', 'M', 2000, 11155588899, 1);
INSERT INTO EMPRESA.funcionario (pnome, minicial, uome, cpf, datanasc, endereço, sexo, salario, cpf_supervisor, dnr) VALUES ('Jose', 'B', 'Souza', 33344455566, '1970-09-09', 'Rua das vertentes, 224', 'M', 2000, 11155588899, 2);
INSERT INTO EMPRESA.localizacoes_dep (Dlocal, Dnumero) VALUES ('Rua das Arueiras, 333', 1);
INSERT INTO EMPRESA.localizacoes_dep (Dlocal, Dnumero) VALUES ('Rua das Mangueiras, 783', 2);
INSERT INTO EMPRESA.projeto (projnome, projnumero, projlocal, dnum) VALUES ('Finanças', 1, 'Rua das Arueiras, 333', 2);
INSERT INTO EMPRESA.projeto (projnome, projnumero, projlocal, dnum) VALUES ('Logistica', 2, 'Rua das Mangueiras, 783', 1);
INSERT INTO EMPRESA.trabalha_em (fcpf, pnr, horas) VALUES (11122277788, 1, '20:00:00');
INSERT INTO EMPRESA.trabalha_em (fcpf, pnr, horas) VALUES (33344455566, 1, '24:00:00');


