var btnSend = document.getElementById('btnSend');
var btnList = document.getElementById('btnList');
var listElement = document.querySelector('#app ul');
var list = [];

function add() {
  var nameInput = document.getElementById('nome').value;
  var surnameInput = document.getElementById('sobrenome').value;
  var ageInput = document.getElementById('idade').value;

  if (!nameInput || !surnameInput || !ageInput)
    return alert('Preencha todos os campos!');

  list.push({ nameInput, surnameInput, ageInput });

  nameInput = '';

  alert('Usuário Salvo')
}

btnSend.onclick = add;

function render() {
  listElement.innerHTML = '';

  for (pos of list) {
    var posElement = document.createElement('li');
    var posText = document.createTextNode(
      `${pos.nameInput} ${pos.surnameInput}: ${pos.ageInput} anos`);

    posElement.appendChild(posText);
    listElement.appendChild(posElement);
  }
}

btnList.onclick = render;
