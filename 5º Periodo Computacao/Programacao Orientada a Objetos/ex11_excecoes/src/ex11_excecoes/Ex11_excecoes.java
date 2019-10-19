/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex11_excecoes;

import Classes.*;
import static java.lang.System.in;
import java.util.Scanner;


/**
 *
 * @author matheus
 */
public class Ex11_excecoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exceptions ex = new Exceptions();
        
        Scanner input = new Scanner(in);
        double nota;
            
        while(true) {
            System.out.println("Nota: ");
            nota = input.nextDouble();
            try {
                ex.excecoes(nota);
            } catch(NumeroNegativoException e) {
                System.out.println(e.getMessage());
            } catch(Acima100Exception e) {
                System.out.println(e.getMessage());
            } 
        }
    }
    
}
