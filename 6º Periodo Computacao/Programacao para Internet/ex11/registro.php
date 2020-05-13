<?php

  $con = new mysqli('localhost', 'root', '', 'locadora');

  if ($con->connect_error) {
    echo "Error: ".$con->connect_error;
  } else {
    $stmt = $con->prepare("INSERT INTO filmes(nome, ano, duracao, genero) VALUES(?,?,?,?);");
    $stmt->bind_param("ssss", $nome, $ano, $duracao, $genero);

    $nome = $_POST["nome"];
    $ano = $_POST["ano"];
    $duracao = $_POST["duracao"];
    $genero = $_POST["genero"];

    $stmt->execute();

    echo "Cadastrado com sucesso!";
  }

  echo "<br><a href='../ex11'>Voltar</a>";

?>