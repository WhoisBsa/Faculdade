CREATE TABLE Produto (
	codigo_produto VARCHAR(5),
	nome_produto VARCHAR(80),
	custo_unitario FLOAT,
	PRIMARY KEY (codigo_produto)
);

CREATE TABLE Receita (
	codigo_receita VARCHAR(5),
	nome_receita VARCHAR(80),
	custo_total FLOAT,
	PRIMARY KEY (codigo_receita)
);

CREATE TABLE Ingrediente (
	codigo_receita VARCHAR(5),
	codigo_produto VARCHAR(5),
	quantidade FLOAT,
	PRIMARY KEY (codigo_receita, codigo_produto, quantidade),
	FOREIGN KEY (codigo_receita)
	REFERENCES Receita (codigo_receita),
	FOREIGN KEY (codigo_produto)
	REFERENCES Produto (codigo_produto) 
);

insert into produto(codigo_produto, nome_produto, custo_unitario) values ('1', 'arroz', 5), ('2', 'feijao', 3);

insert into receita(codigo_receita, nome_receita, custo_total) values ('3', 'feijoada', 10), ('4', 'arroz a grega', 4);

insert into ingrediente(codigo_receita, codigo_produto, quantidade) values ('3', '2', 15), ('4', '1', 10);

select produto.nome_produto
from
	produto JOIN ingrediente
ON
	produto.codigo_produto = ingrediente.codigo_produto join receita
ON
	ingrediente.codigo_receita = receita.codigo_receita
group by produto.nome_produto
having count(produto.nome_produto) > 1;

DELIMITER $$
CREATE PROCEDURE produtos()
BEGIN
SELECT * FROM produto;
END $$ DELIMITER;

DELIMITER $$
CREATE PROCEDURE receitas()
BEGIN
SELECT * FROM receita;
END $$ DELIMITER;

DELIMITER $$
CREATE PROCEDURE ingrdientes()
BEGIN
SELECT * FROM ingrediente;
END $$ DELIMITER;

DELIMITER $$
CREATE PROCEDURE receitaIngredienteProduto()
BEGIN
SELECT RECEITA.nome_receita, PRODUTO.nome_produto, FROM ingrediente JOIN produto

ON 
	ingrediente.codigo_produto = produto.codigo_produto JOIN receita
ON
	ingrediente.codigo_receita = receita.codigo_receita;
END $$ DELIMITER;
matheus