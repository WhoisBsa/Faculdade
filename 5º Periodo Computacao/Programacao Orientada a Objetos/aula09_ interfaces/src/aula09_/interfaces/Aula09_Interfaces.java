/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula09_.interfaces;

import Classes.*;

/**
 *
 * @author matheus
 */
public class Aula09_Interfaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaInterno sI = new SistemaInterno();
        Gerente g = new Gerente("Matheus", 123);
        sI.login(g);
    }
    
}
