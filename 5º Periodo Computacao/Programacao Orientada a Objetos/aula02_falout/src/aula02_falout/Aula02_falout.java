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

import Classes.Amigo;
import Classes.Inimigo;
import java.util.Scanner;

public class Aula02_falout {

    
    public static void main(String[] args) {
        Inimigo alduin = new Inimigo(80, 40, 90, 40);
        Amigo eu = new Amigo(); 
        
        Scanner s = new Scanner(System.in);
        
        while (alduin.healt > 0 && eu.getHealt() > 0) {
            System.out.println("Onde você quer atacar?");
            System.out.println("1 - Cabeça\n2 - Braços\n3 - Pernas");
            int op = s.nextInt();
            alduin.atack(op);
            eu.atackFriend();
            System.out.println("O inimigo tem " + alduin.healt + " de vida!");
            System.out.println("Você tem " + eu.getHealt() + " de vida!");
        }
        
        //LIFE INFINITA
        eu.setHealt(100);
        System.out.println("Você tem " + eu.getHealt() + " de vida!");
        //
        
        if (alduin.healt <= 0)
            System.out.println("O inimigo está morto!");
        if (eu.getHealt() <= 0)
            System.out.println("O inimigo está morto!");
    }
    
}
