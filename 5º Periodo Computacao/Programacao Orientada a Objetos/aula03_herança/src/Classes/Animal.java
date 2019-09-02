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
public class Animal {
    protected String olhos;
    protected double peso;
    protected double tamanho;
    protected String cor;
    
    public Animal() {
        
    }
    
    public Animal(String olhos, double peso, double tamanho, String cor) {
        this.olhos = olhos;
        this.peso = peso;
        this.tamanho = tamanho;
        this.cor = cor;
    }
    
    public void movimentar() {
        System.out.println(" está se movimentando!");
    }

    public String getOlhos() {
        return olhos;
    }

    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    
}
