/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancário2;

import Classes.*;
import Views.ViewMenu;

/**
 *
 * @author matheus
 */
public class SistemaBancário2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banco banco = new Banco();
        ContaCorrente[] contaCorrente = new ContaCorrente[10];
        
        contaCorrente[0] = new ContaCorrente(1, 2000);
        
        banco.inserir(contaCorrente[0]);

        ViewMenu viewMenu = new ViewMenu(banco);
        viewMenu.setVisible(true);
    }
    
}
