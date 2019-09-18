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
    private int qtdFunc;
    
    public Gerente() {}
    
    public Gerente(String nome, int idade, double salario, int codFunc, int qtdFunc) {
        super(nome, idade, salario, codFunc);
        this.qtdFunc = qtdFunc;
    }
    
    @Override
    public void mostrarDados() {
        super.mostrarDados("Gerente");
        System.out.println("Quantidade funcionarios gerenciados: " + this.qtdFunc);
    }
}
