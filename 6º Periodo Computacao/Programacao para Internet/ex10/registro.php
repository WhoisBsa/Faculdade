<?php

  $con = new mysqli('localhost', 'root', '', 'escola');

  if ($con->connect_error) {
    echo "Error: ".$con->connect_error;
  } else {
    $stmt = $con->prepare("INSERT INTO aluno(nome, idade, faltas, nota) VALUES(?,?,?,?);");
    $stmt->bind_param("ssss", $nome, $idade, $faltas, $nota);

    $nome = $_POST["nome"];
    $idade = $_POST["idade"];
    $faltas = $_POST["faltas"];
    $nota = $_POST["nota"];

    $stmt->execute();

    echo "Cadastrado com sucesso!";
  }

?>