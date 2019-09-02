/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03;

import Classes.Animal;
import Classes.Cachorro;
import Classes.Gato;

/**
 *
 * @author matheus
 */
public class Aula03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animal animal = new Animal("Azuis", 2.5, 0.35, "Preto");
        animal.movimentar();
        System.out.println("O animal é: " + animal.getCor());
        
        Cachorro cachorro = new Cachorro("Pretos", 5.5, 1.35, "Branco");
        cachorro.latir();
        cachorro.movimentar();

        Gato gato = new Gato("Verdes", 1.5, 0.25, "Amarelo");
        gato.miar();
        gato.movimentar();
    }
    
}
