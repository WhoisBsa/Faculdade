/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author matheus
 */
public class Gerente extends Funcionario {
    
    private int idGerencia;
    
    public Gerente(String nome, String cpf, double salario, int idGerencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.idGerencia = idGerencia;
    }
    
    @Override
    public void ponto() {
        System.out.print("O gerente");
        super.ponto();
    }
    
    public void gerenciar() {
        System.out.println("O gerente " + this.idGerencia + " está gerenciando...");
    }
}
