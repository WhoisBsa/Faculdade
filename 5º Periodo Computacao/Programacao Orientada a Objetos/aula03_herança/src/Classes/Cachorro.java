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
public class Cachorro extends Animal {
    
    public Cachorro() {
        
    }
    
    public Cachorro(String olhos, double peso, double tamanho, String cor) {
        this.olhos = olhos;
        this.peso = peso;
        this.tamanho = tamanho;
        this.cor = cor;   
    }
    
    @Override
    public void movimentar() {
        System.out.print("O cachorro");
        super.movimentar();
    }
    
    public void latir() {
        System.out.println("O cachorro " + this.cor + " está latindo...");
    }
}
