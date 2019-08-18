package aula01;

import Classes.Cliente;
import java.util.Scanner;

public class Aula01 {

    public static void main(String[] args) {
        Cliente c1 = new Cliente();

        c1.nome = "Matheus";
        c1.idade = 19;
        c1.cpf = "11122233344";
        c1.saldo = 100;

        Cliente c2 = new Cliente();

        Scanner s = new Scanner(System.in);

    	/*System.out.println("Bem vindo ao cadastro de clientes");
    	System.out.println("Nome: ");
    	c2.nome = s.nextLine();

    	System.out.println("CPF: ");
    	c2.cpf = s.nextLine();

    	System.out.println("Idade: ");
    	c2.idade = Integer.parseInt(s.nextLine());*/

    	// c1.mensagem();
    	// c2.mensagem();

    	// String msg = c1.mensagemRetorno();
        
        // System.out.println(msg);

    	c1.itsaFriend(c2);

    	c1.acrecimo();
    }
    
}
