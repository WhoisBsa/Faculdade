<?php

  $con = new mysqli('localhost', 'root', '', 'produtosphp');

  if ($con->connect_error) {
    echo "Error: ".$con->connect_error;
  } else {
    $stmt = $con->prepare("INSERT INTO produtos (marca,nome,preco) VALUES (?,?,?)");
    $stmt->bind_param("sss", $marca, $nome, $preco);

    $marca = $_POST["marca"];
    $nome = $_POST["nome"];
    $preco = $_POST["preco"];

    $stmt->execute();

    echo "Cadastrado com sucesso!";
  }

?>