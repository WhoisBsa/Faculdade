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
public abstract class PessoaJuridica extends Pessoa{
    protected double faturamento;
    
    public PessoaJuridica() {}
    
    public PessoaJuridica(String nome, String cpfcnpj, double faturamento) {
        super(nome, cpfcnpj);
        this.faturamento = faturamento;
    }
}
