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
public class Morcego extends Animal implements Voar, Empoleirar {
    private int dentes;
    
    public Morcego() {}

    public Morcego(double peso, String cor, double tamanho, int dentes) {
        super(peso, cor, tamanho);
        this.dentes = dentes;
    }
    
    @Override
    public  void comer() {
        System.out.println("O morcego está comendo");
    }
    
    @Override
    public void dormir() {
        System.out.println("O morcego está dormindo");
    }
    
    @Override
    public void voar() {
        System.out.println("O morcego está voando");
    }
    
    @Override
    public void empoleirar(){
        System.out.println("O morcego esta empoleirando");
    }
}
        