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
public class Cliente extends Pessoa{
    protected String tipo;
    
    public Cliente() {}
    
    public Cliente(String nome, int idade, String tipo) {
        super(nome, idade);
        this.tipo = tipo;
    }
    
    public void mostrarDados() {
        System.out.println("Seu nome: " + this.nome);
        System.out.println("Sua idade: " + this.idade);
        System.out.println("Tipo: " + this.tipo);
    }
}
