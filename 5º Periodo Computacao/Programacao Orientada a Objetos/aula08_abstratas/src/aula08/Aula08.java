/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula08;

import Classes.*;

/**
 *
 * @author matheus
 */
public class Aula08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vendedor v = new Vendedor("Matheus", "12345678910", 1000);
        System.out.println(v.getNome() + " tem o CPF: " + v.getCpf());
        v.getAuxilio();
        
        Gerente g = new Gerente("Rafael", "7945612398", 2000);
        System.out.println(g.getNome() + " tem o CPF: " + g.getCpf());
        g.getAuxilio();
        
        // Funcionario f = new Funcionario("Hemilio", "74185293312");
        // System.out.println(f.getNome() + " tem o CPF: " + f.getCpf());

        SecretariaFinanceira s = new SecretariaFinanceira("Gustavo", "7988872398", 1500);
        System.out.println(s.getNome() + " tem o CPF: " + s.getCpf());
        s.getAuxilio();
    }
    
}
