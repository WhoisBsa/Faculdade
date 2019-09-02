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
public class Vendedor extends Funcionario {
    
    private int nVendas;
    
    public Vendedor() {
        
    }
    
    public Vendedor(String nome, String cpf, double salario, int nVendas) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.nVendas = nVendas;
    }
    
    @Override
    public void ponto() {
        System.out.print("O vendedor");
        super.ponto();
    }
    
    public void vender() {
        System.out.println("O vendedor está vendendo " + this.nVendas + " produtos...");
    }
}
