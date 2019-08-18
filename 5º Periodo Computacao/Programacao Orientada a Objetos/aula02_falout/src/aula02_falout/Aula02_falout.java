/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02_falout;

/**
 *
 * @author matheus
 */

import Classes.Inimigo;

public class Aula02_falout {

    
    public static void main(String[] args) {
        Inimigo alduin = new Inimigo();
        /*
        alduin.leg();
        alduin.body();
        alduin.headShot();
        */
        alduin.atack(3);
        alduin.atack(4);
        alduin.atack(1);
    }
    
}
