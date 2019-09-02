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
public class Funcionario extends Pessoa {
    protected double salario;
    protected int codFunc;
    protected String tipoFunc;
    
    public Funcionario() {}
    
    public Funcionario(String nome, int idade, double salario, int codFunc) {
        super(nome, idade);
        this.salario = salario;
        this.codFunc = codFunc;
    }
    
    public void mostrarDados() {
        System.out.println("Seu nome: " + this.nome);
        System.out.println("Sua idade: " + this.idade);
        System.out.println("Codigo do funcionario: " + this.codFunc);
        System.out.println("Salario: R$" + this.salario);
    }
    
    public void mostrarDados(String tipo) {
        System.out.println("Seu nome: " + this.nome);
        System.out.println("Sua idade: " + this.idade);
        System.out.println("Codigo do " + tipo + ": "  + this.codFunc);
        System.out.println("Salario: R$" + this.salario);
    }
}
