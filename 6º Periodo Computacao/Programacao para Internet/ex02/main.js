var doenca = ["Gripe", "Desidratação", "Tuberculose"];

var paciente = [
	{
		nome: "Matheus Barbosa Souza",
		idade: 20,
		cpf: "14119369650",
		tSanguineo: "O+",
		conjuntos: [1],
		resultado: []
	},
	{
		nome: "Rafael Sidnei Alves",
		idade: 30,
		cpf: "12345678965",
		tSanguineo: "AB-",
		conjuntos: [2, 3],
		resultado: []
	},
	{
		nome: "Hemílio Láuro de Araújo Melo",
		idade: 31,
		cpf: "20123687565",
		tSanguineo: "O-",
		conjuntos: [1, 3],
		resultado: []
	},
	{
		nome: "Lucas Nogueira Santos",
		idade: 22,
		cpf: "12345678925",
		tSanguineo: "B+",
		conjuntos: [2, 3],
		resultado: []
	},
	{
		nome: "Gustavo de Paula Silva",
		idade: 23,
		cpf: "98765432125",
		tSanguineo: "A+",
		conjuntos: [1, 3],
		resultado: []
	},
	{
		nome: "Robson de Souza Rezende",
		idade: 29,
		cpf: "14725896354",
		tSanguineo: "A+",
		conjuntos: [2],
		resultado: []
	},
	{
		nome: "Jose Moreira Machado",
		idade: 82,
		cpf: "32165474125",
		tSanguineo: "O-",
		conjuntos: [3],
		resultado: []
	},
	{
		nome: "Matheus Moreira Machado",
		idade: 20,
		cpf: "36542147856",
		tSanguineo: "B-",
		conjuntos: [2, 3],
		resultado: []
	},
	{
		nome: "José Maria Batista",
		idade: 57,
		cpf: "65478936955",
		tSanguineo: "A-",
		conjuntos: [1, 2, 3],
		resultado: []
	},
	{
		nome: "Luiz Carlos Souza",
		idade: 40,
		cpf: "15995145625",
		tSanguineo: "B+",
		conjuntos: [],
		resultado: []
	}
];

var diagnostico = []

for (let i in paciente) {
	if (paciente[i].conjuntos.includes(1)) {
		paciente[i].resultado.push(doenca[0]);
	}
	if (paciente[i].conjuntos.includes(2)) {
		paciente[i].resultado.push(doenca[1]);
	}
	if (paciente[i].conjuntos.includes(3)) {
		paciente[i].resultado.push(doenca[2]);
	}

	diagnostico[i] = `O paciente ${paciente[i].nome}, possui ${paciente[i].idade} anos de idade. 
	Seu CPF é: ${paciente[i].cpf} e o seu tipo sanguíneo é ${paciente[i].tSanguineo}. 
	De acordo com os sintomas apresentados, o senhor ${paciente[i].nome}
	está com `;

	for (let index = 0; index < paciente[i].resultado.length; index++) {
		if(index == paciente[i].resultado.length-1)
			diagnostico[i] += `${paciente[i].resultado[index]}.`	
		else
			diagnostico[i] += `${paciente[i].resultado[index]} e `	
	}

	if (paciente[i].resultado.length == 0)
		diagnostico[i] += 'nenhum indício de doença.'

	document.write(`
	<div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-5">Paciente ${parseInt(i)+1}</h1>
            <p class="lead">${diagnostico[i]}</p>
            <hr class="my-2">
        </div>
    </div>
	`);
}