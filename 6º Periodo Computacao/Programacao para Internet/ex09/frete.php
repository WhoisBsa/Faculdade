<?php

  $_valor = intval( $_POST["valor"] );
  $_cidade = $_POST["cidade"];
  $_soma = 0;

  if ($_cidade == "36400000"){
    $_soma = $_valor + 25;
    echo "Frete no valor de R$$_soma";
  } else if ($_cidade == "22500111"){
    $_soma = $_valor + 22.4;
    echo "Frete no valor de R$$_soma";
  } else if ($_cidade == "17849012"){
    $_soma = $_valor + 17.8;
    echo "Frete no valor de R$$_soma";
  } else if ($_cidade == "55400222"){
    $_soma = $_valor + 45;
    echo "Frete no valor de R$$_soma";
  } else if ($_cidade == "45321123"){
    $_soma = $_valor + 37.2;
    echo "Frete no valor de R$$_soma";
  } else{
    echo "CEP inválido. <a href='../ex09'>Preencher novamente.</a>";
  }
?>