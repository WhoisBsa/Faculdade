/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancário2;

import Classes.*;
import Views.ViewMenu;
import java.util.ArrayList;

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
        ArrayList<ContaCorrente> contaCorrente = new ArrayList<>();
        
        contaCorrente.add(new ContaCorrente(1, 2000));
        contaCorrente.add(new ContaCorrente(2, 400));
        contaCorrente.add(new ContaCorrente(3, 5500));
        contaCorrente.add(new ContaCorrente(4, 820));
        
        System.out.println(contaCorrente.get(0));
        banco.inserir(contaCorrente.get(0));
        banco.inserir(contaCorrente.get(1));
        banco.inserir(contaCorrente.get(2));
        banco.inserir(contaCorrente.get(3));

        ViewMenu viewMenu = new ViewMenu(banco);
        viewMenu.setVisible(true);
    }
    
}
