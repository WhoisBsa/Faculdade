console.log('Digite a expressão - Por exemplo 2 + 2 ou 2 * 2')

const readline = require('readline')

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('Expressão: ', (answer) => {
  console.log(`Resultado: ${eval(answer)}`);
  rl.close();
});