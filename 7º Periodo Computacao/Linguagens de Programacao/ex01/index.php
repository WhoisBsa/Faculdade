<html>
  <head>
    <title>PHP Test</title>
  </head>
  <body>
  <form method="POST">
    <input type="text" name="content" id="login">
    <button type="submit" name="btnadd">Enviar</button>
  </form>

    <?php 
    if (isset($_POST["btnadd"])){
      echo 'Resultado: ';
      eval('echo '.$_POST["content"]. ';');
    }
    ?>
  </body>
</html>