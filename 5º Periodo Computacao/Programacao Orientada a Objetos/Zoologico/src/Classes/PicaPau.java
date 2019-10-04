/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.Bicar;
import Interfaces.Voar;

/**
 *
 * @author matheus
 */
public class PicaPau extends Animal implements Voar, Bicar {
    private int asa;
    private int bico;
    
    public PicaPau() {}
    
    public PicaPau(double peso, String cor, double tamanho, int asa, int bico) {
        super(peso, cor, tamanho);
        this.asa = asa;
        this.bico = bico;
    }
    
    
    @Override
    public  void comer() {
        System.out.println("O pica-pau está comendo");
    }
    
    @Override
    public void dormir() {
        System.out.println("O pica-pau está dormindo");
    }
    
    @Override
    public void voar(){
        System.out.println("O pica-pau esta voando");
    }
    
    @Override
    public void bicar(){
        System.out.println("O pica-pau esta bicando");
    }
}
