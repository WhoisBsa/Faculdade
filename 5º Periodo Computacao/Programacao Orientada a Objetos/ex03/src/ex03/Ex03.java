/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex03;

import Classes.Funcionario;
import Classes.Gerente;
import Classes.Vendedor;

/**
 *
 * @author matheus
 */
public class Ex03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcionario func = new Funcionario("Funcionario", "111.111.111-11", 0.0);
        func.ponto();
        
        Gerente gerente = new Gerente("Matheus", "111.111.111-11", 50000, 1234);
        gerente.ponto();
        gerente.gerenciar();
        
        Vendedor vendedor = new Vendedor("Robson", "111.111.111-11", 60000, 2000);
        vendedor.ponto();
        vendedor.vender();
    }
    
}
