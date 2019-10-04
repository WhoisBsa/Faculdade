/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoologico;

import Classes.*;

/**
 *
 * @author matheus
 */
public class Zoologico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tigre tigre = new Tigre();
        Macaco macaco = new Macaco();
        PicaPau picaPau = new PicaPau();
        Avestruz avestruz = new Avestruz();
        Morcego morcego = new Morcego();
        Preguica preguica = new Preguica();
        
        tigre.dormir();
        tigre.correr();
        System.out.println("");
        
        macaco.dormir();
        macaco.escalar();
        System.out.println("");
        
        picaPau.dormir();
        picaPau.bicar();
        System.out.println("");
        
        avestruz.bicar();
        avestruz.correr();
        System.out.println("");
        
        morcego.voar();
        morcego.empoleirar();
        System.out.println("");
        
        preguica.escalar();
        preguica.comer();
        System.out.println("");
    }
    
}
