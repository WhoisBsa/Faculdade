/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showdomilhão;

import Classes.Jogador;
import Views.ViewInicial;

/**
 *
 * @author matheus
 */
public class ShowDoMilhão {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jogador jogador = new Jogador();
        
        ViewInicial inicial = new ViewInicial(jogador);
        inicial.setVisible(true);
    }
    
}
