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
public class Gato extends Animal {

    public Gato() {
        
    }
    
    public Gato(String olhos, double peso, double tamanho, String cor) {
        super(olhos, peso, tamanho, cor);
    }
    
    @Override
    public void movimentar() {
        System.out.print("O gato");
        super.movimentar();
    }
    
    public void miar() {
        System.out.println("O gato " + this.cor + " está miando...");
    }
}
