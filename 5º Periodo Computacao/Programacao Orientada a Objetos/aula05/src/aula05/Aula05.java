/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04;

import Classes.Cliente;
import Classes.Funcionario;
import Classes.Gerente;
import Classes.Vendedor;

/**
 *
 * @author matheus
 */
public class Aula04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente usuario = new Cliente("Matheus", 19, "Platinum");
        Funcionario rafael = new Funcionario("Rafael", 31, 3000, 12345);
        
        usuario.mostrarDados();
        rafael.mostrarDados();
        
        Gerente lucas = new Gerente("Lucas", 38, 6000, 123456, 800);
        Vendedor gustavo = new Vendedor("Gustavo", 19, 1200, 212385, 500);
        
        lucas.mostrarDados();
        gustavo.mostrarDados();
    }
    
}
