pedido(_idPed_, data_de_entrega, quantidade, #nomePr)
cliente(_CPF_, nome, tel, email, endereço, dataNasc, #idPed, #idAdm)
administrador(_idAdm_, nome, #idFun)
funcionario(_idFun_, nome, #idAdm)
produto(_idPro_, nome, modelo, preco, marca, #idPed)

select *,
from produto p, pedidos pe,  
where p.nome = 'teclado' and pe.data_de_entrega = 28/09/18;

select *,
from pedido p, cliente c,
where p.data_de_entrega LIKE '__/09/____' and c.nome = 'Joao Gilberto'and p.idPed = c.idPed;

select *
from cliente c, pedido p,
where c.dataNasc LIKE '__/08/____' and c.idPed = p.idPed;

select count(*)
from pedido p,
where p.data_de_entrega LIKE '__/__/2017';

select nome, sum(quantidade),
from pedido p, produto pr,
where p.data_de_entrega LIKE '__/03/2018' and p.idPed = pr.idPed and p.nomePR = pr.nome;