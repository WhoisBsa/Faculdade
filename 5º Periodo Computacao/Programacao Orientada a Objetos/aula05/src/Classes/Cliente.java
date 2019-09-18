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

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    private String tipo;
    
    public Cliente() {}
    
    public Cliente(String nome, int idade, String tipo) {
        super(nome, idade);
        this.tipo = tipo;
    }
    
    public void mostrarDados() {
        System.out.println("Seu nome: " + this.nome);
        System.out.println("Sua idade: " + this.idade);
        System.out.println("Tipo: " + this.getTipo());
    }
}
