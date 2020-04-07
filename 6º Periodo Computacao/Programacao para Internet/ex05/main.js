var button = document.querySelector('#app button');
var lista = document.getElementById('lista');

var produtos = [];


function checaIguais(nome, produtos) {
  console.log(produtos, nome,'fora do for checaiguais');

  for (produto of produtos) {
    console.log(produto, nome, 'dentro do for');
    
    if (produto.nome === nome) {
      console.log(produto.nome, nome);
      return true;
    }
  }
}


button.onclick = () => {
  var marca = document.getElementById('marca').value;
  var nome = document.getElementById('nome').value;
  var preco = document.getElementById('preco').value;

  if (marca == "" || nome == "" || preco == "") {
    alert('Preencha todos os campos');
    return;
  }

  if (checaIguais(nome, produtos)) { 
    alert('Produto repetido'); 
    return; 
  }

  produtos.push({ marca, nome, preco });  

  lista.innerHTML = '';
  for (produto of produtos) {
    console.log(produtos, produto.nome, 'for main ');

    var divElement = document.createElement('div');
    divElement.classList.add('divElement');

    var divHeader = document.createElement('div');
    var headerText = document.createTextNode(produto.marca);
    divHeader.classList.add('divHeader');
    divHeader.appendChild(headerText);

    var divBody = document.createElement('div');
    var bodyText = document.createTextNode(produto.nome);
    divBody.classList.add('divBody');
    divBody.appendChild(bodyText);

    var divPreco = document.createElement('div');
    var precoText = document.createTextNode(`R$ ${produto.preco}`);
    divPreco.classList.add('divPreco');
    divPreco.appendChild(precoText);

    divElement.append(divHeader, divBody, divPreco);

    lista.appendChild(divElement);
  }
}
