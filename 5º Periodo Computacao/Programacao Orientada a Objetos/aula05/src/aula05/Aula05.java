/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula05;

import Classes.Cliente;
import java.util.Scanner;

/**
 *
 * @author matheus
 */
public class Aula05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente clientes[] = new Cliente[50];
        Scanner input = new Scanner(System.in);
        int op = 0, i = 0, idade;
        String nome, tipo;

        while (op != 3) {
            System.out.println("\n1 - Cadastrar");
            System.out.println("2 - Mostrar");
            System.out.println("3 - Sair");
            System.out.print("\nSelecione: ");
            op = input.nextInt();
            System.out.println("");

            switch (op) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    nome = input.next();                    
                    System.out.print("Digite sua idade: ");
                    idade = input.nextInt();
                    System.out.print("Digite o tipo de cliente: ");
                    tipo = input.next();
                    clientes[i] = new Cliente(nome, idade, tipo);
                    i++;
                    break;
                case 2:
                    if(i == 0)
                        System.out.println("Nenhum cliente cadastrado\n");
                    else{
                        for(int j = 0; j < i; j++){
                            clientes[j].mostrarDados();
                            System.out.println("");
                        }
                    }
                    break;
            }
        }
    }

}
