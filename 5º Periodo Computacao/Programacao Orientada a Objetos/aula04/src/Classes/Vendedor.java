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
    private int qtdVendas;
    
    public Vendedor() {}
    
    public Vendedor(String nome, int idade, double salario, int codFunc, int qtdVendas) {
        super(nome, idade, salario, codFunc);
        this.qtdVendas = qtdVendas;
    }
    
    @Override
    public void mostrarDados() {
        super.mostrarDados("Vendedor");
        System.out.println("Quantidade de vendas: " + this.qtdVendas);
    }
}
