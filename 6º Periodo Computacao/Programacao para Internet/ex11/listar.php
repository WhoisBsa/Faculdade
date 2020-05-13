<?php

  $con = new mysqli('localhost', 'root', '', 'locadora');

  if ($con->connect_error) {
    echo "Error: ".$con->connect_error;
  } else {
    $sql = mysqli_query($con, "SELECT * FROM filmes");

    while($aux = mysqli_fetch_assoc($sql)) { 
      echo "-----------------------------------------<br>"; 
      echo "Nome: ".$aux["nome"]."<br>"; 
      echo "Ano: ".$aux["ano"]."<br>";
      echo "Duração: ".$aux["duracao"]." minutos<br>";
      echo "Gênero: ".$aux["genero"]."<br>";
    }
  }

  echo "<br><a href='../ex11'>Voltar</a>";
?>