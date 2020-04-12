
/////////////////////////////////////////////
//                                         //
//              6° Período CC              //
//  Calculo do Método das Cordas Secantes  //
//          Matheus Barbosa Souza          //
//                                         //
/////////////////////////////////////////////

var x0 = 1.5;
var x1 = 1.7;
var fx0 = 0.0;
var fx1 = 0.0;
var xk = 0.0;
var err = 1.1;
var aux = 0.0;
var tol = 0.02;
var i = 0;

while (err > tol) {
  fx0 = x0 ** 2 + x0 - 6;  // aqui você calcula a f(x0)
  fx1 = x1 ** 2 + x1 - 6;  // aqui você calcula a f(x1)
  aux = xk;                // guarda o xk pro cálculo do erro
  xk = x1 - fx1 * (x1 - x0) / (fx1 - fx0);  // func para achar o xk

  if (i == 0)  // ignora o primeiro erro
    console.log(x0.toFixed(4),
      fx1.toFixed(4),
      x1.toFixed(4),
      fx0.toFixed(4),
      xk.toFixed(4),
      '-');
  else {
    err = Math.abs(aux - xk);  // calcula o MÓDULO do erro 
    console.log(x0.toFixed(4),
      fx1.toFixed(4),
      x1.toFixed(4),
      fx0.toFixed(4),
      xk.toFixed(4),
      err.toFixed(4));
  }  

  // faz cair no else para cálculo do erro
  i  = 1;
  // faz a transição de váriaveis
  x0 = x1;
  x1 = xk;
}
