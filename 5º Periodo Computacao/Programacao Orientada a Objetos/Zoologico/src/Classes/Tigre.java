/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.*;

/**
 *
 * @author matheus
 */
public class Tigre extends Animal implements Correr {
    private int patas;
    private int rabo;
    
    public Tigre() {}
    
    public Tigre(double peso, String cor, double tamanho, int patas, int rabo) {
        super(peso, cor, tamanho);
        this.patas = patas;
        this.rabo = rabo;
    }
    
    @Override
    public  void comer() {
        System.out.println("O tigre está comendo");
    }
    
    @Override
    public void dormir() {
        System.out.println("O tigre está dormindo");
    }
    
    @Override
        public void correr() {
        System.out.println("O tigre está correndo");
    }
}
