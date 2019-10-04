/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.Bicar;
import Interfaces.Correr;

/**
 *
 * @author matheus
 */
public class Avestruz extends Animal implements Bicar, Correr {
    private int asa;
    private int bico;
    
    public Avestruz() {}
    
    public Avestruz(double peso, String cor, double tamanho, int asa, int bico) {
        super(peso, cor, tamanho);
        this.asa = asa;
        this.bico = bico;
    }
    
    
    @Override
    public  void comer() {
        System.out.println("O avestruz está comendo");
    }
    
    @Override
    public void dormir() {
        System.out.println("O avestruz está dormindo");
    }
    
    @Override
    public void bicar(){
        System.out.println("O Avestruz esta bicando");
    }
    
    @Override
    public void correr(){
        System.out.println("O Avestruz esta correndo");
    }
}
