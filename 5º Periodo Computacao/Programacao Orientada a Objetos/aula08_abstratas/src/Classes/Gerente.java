/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author matheus
 */
public class Gerente extends Funcionario {
    
    public Gerente() {}
    
    public Gerente(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    
    @Override
    public void getAuxilio() {
        System.out.println(nome + " recebe ao todo R$ " + salario * 1.1);
    }
}
