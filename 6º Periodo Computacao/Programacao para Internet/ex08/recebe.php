<?php

  $_nome = $_POST["nome"];
  $_sobrenome = $_POST["sobrenome"];
  $_idade = $_POST["idade"];
  $_cpf = $_POST["cpf"];
  $_estadoC = $_POST["estadoC"];

  if ($_idade < 18)
    echo "<h2>O usuário é menor de 18 anos. Não é possível mostrar os dados.<h2>";
  else {
    echo "Nome: $_nome $_sobrenome<br>
          Idade: $_idade<br> 
          CPF: $_cpf<br> 
          Estado Civil: $_estadoC";
  }

?>