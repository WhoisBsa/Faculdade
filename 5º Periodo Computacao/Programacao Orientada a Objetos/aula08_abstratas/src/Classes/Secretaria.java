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
public abstract class Secretaria extends Funcionario{
    
    public Secretaria() {}
    
    public Secretaria(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
}
