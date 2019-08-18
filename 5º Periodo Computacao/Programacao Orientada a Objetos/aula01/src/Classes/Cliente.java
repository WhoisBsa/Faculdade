package Classes;

public class Cliente {
    public String nome;
    public String cpf;
    public int idade;
    public double saldo;

    public void mensagem() {
    	System.out.println(this.nome + " tem " + this.idade + " anos de idade de cpf: " + this.cpf);
    }

    public String mensagemRetorno() {
    	String s = this.nome + " tem " + this.idade + " anos de idade de cpf: " + this.cpf;
    	
    	return s;
    }

	public void itsaFriend(Cliente c) {
		System.out.println(this.nome + " é amigo de " + c.nome);
	}

	public void acrecimo() {
            this.saldo = this.saldo * 1.1;
            System.out.println("O acrecimo foi de R$" + this.saldo);
	} 
}
