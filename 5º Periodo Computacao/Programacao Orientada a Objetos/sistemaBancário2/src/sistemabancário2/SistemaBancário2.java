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
        ContaPoupanca[] contaPoupanca = new ContaPoupanca[10];
        
        contaCorrente[0] = new ContaCorrente(1, 2000, 0.1);
        contaPoupanca[0] = new ContaPoupanca(2, 1000, 400);
        
        banco.inserir(contaCorrente[0]);
        banco.inserir(contaPoupanca[0]);
                
        ViewMenu viewMenu = new ViewMenu(banco);
        viewMenu.setVisible(true);
    }
    
}
