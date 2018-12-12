create database HOSPITAL;

create table Hospital(
	idHospital	int	not null    primary key,
	Ambulatorio	xml,
	Medico		xml,
	Paciente	xml,
	Consulta	xml,
	Funcionario	xml
);

insert into Hospital(idHospital, Ambulatorio, Medico, Paciente, Consulta, Funcionario) 
values(1,
'<ambulatorios>
	<ambulatorio>
		<numeroA>3</numeroA>
		<andar>2</andar>
		<capacidade>9</capacidade>
	</ambulatorio>
	<ambulatorio>
		<numeroA>5</numeroA>
		<andar>3</andar>
		<capacidade>15</capacidade>
	</ambulatorio>
</ambulatorios>',

'<medicos>
	<medico>
		<crm>105090</crm>
		<rm>20143220</rm>
		<nome>Matheus Barbosa</nome>
		<idade>18</idade>
		<cidade>Capela Nova</cidade>
		<especialidade>Otorrinolaringologista</especialidade>
		<numeroA>5</numeroA>
	</medico>
	<medico>
		<crm>106000</crm>
		<rm>20143330</rm>
		<nome>Matheus Souza</nome>
		<idade>18</idade>
		<cidade>Barbacena</cidade>
		<especialidade>Ginecologista</especialidade>
		<numeroA>3</numeroA>
	</medico>
</medicos>',

'<pacientes>
	<paciente>
		<rg>20156820</rg>
		<nome>Jao das Couve</nome>
		<idade>55</idade>
		<cidade>Barbacena</cidade>
		<doenca>Rinite</doenca>
	</paciente>
	<paciente>
		<rg>20785420</rg>
		<nome>Maria das Couve</nome>
		<idade>45</idade>
		<cidade>Barbacena</cidade>
		<doenca>Menopausa</doenca>
	</paciente>
</pacientes>',

'<consultas>
	<consulta>
		<crm>106000</crm>
		<rg>20785420</rg>
		<data>30/12/17</data>
		<hora>15</hora>
	</consulta>
	<consulta>
		<crm>105090</crm>
		<rg>20156820</rg>
		<data>21/12/17</data>
		<hora>14</hora>
	</consulta>
</consultas>',

'<funcionarios>
	<funcionario>
		<rg>20641420</rg>
		<nome>Jose Lopes</nome>
		<idade>45</idade>
		<cidade>Barbacena</cidade>
		<salario>1000</salario>
	</funcionario>
	<funcionario>
		<rg>20854920</rg>
		<nome>Jose Lopes</nome>
		<idade>41</idade>
		<cidade>Capela Nova</cidade>
		<salario>1500</salario>
	</funcionario>
</funcionarios>'
);

select * from hospital
