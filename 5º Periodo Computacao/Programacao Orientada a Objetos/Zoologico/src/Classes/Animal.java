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
public abstract class Animal {
    protected double peso;
    protected String cor;
    protected double tamanho;
    
    public Animal() {}
    
    public Animal(double peso, String cor, double tamanho) {
        this.peso = peso;
        this.cor = cor;
        this.tamanho = tamanho;
    }
    
    public abstract void comer();
    
    public abstract void dormir();
}
