/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.Correr;
import Interfaces.Escalar;

/**
 *
 * @author matheus
 */
public class Macaco extends Animal implements Correr, Escalar {
    private int patas;
    private int rabo;
    
    public Macaco() {}
    
    public Macaco(double peso, String cor, double tamanho, int patas, int rabo) {
        super(peso, cor, tamanho);
        this.patas = patas;
        this.rabo = rabo;
    }
    
    
    @Override
    public  void comer() {
        System.out.println("O macaco está comendo");
    }
    
    @Override
    public void dormir() {
        System.out.println("O macaco está dormindo");
    }
    
    @Override
    public void correr(){
        System.out.println("O macaco esta correndo");
    }
    
    @Override
    public void escalar(){
        System.out.println("O macaco esta escalando");
    }
}
