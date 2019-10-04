/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.Escalar;

/**
 *
 * @author matheus
 */
public class Preguica extends Animal implements Escalar{
    private double horas;
    
    public Preguica() {}

    public Preguica(double peso, String cor, double tamanho, int horas) {
        super(peso, cor, tamanho);
        this.horas = horas;
    }
    
    
    @Override
    public  void comer() {
        System.out.println("A preguiça está comendo");
    }
    
    @Override
    public void dormir() {
        System.out.println("A preguiça está dormindo");
    }
    
    @Override
    public void escalar() {
        System.out.println("A preguiça está escalando");
    }
}
