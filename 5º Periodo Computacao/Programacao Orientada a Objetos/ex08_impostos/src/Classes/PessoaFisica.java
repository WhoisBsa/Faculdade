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
public class PessoaFisica extends Pessoa{
    private double salario;
    
    public PessoaFisica() {}
    
    public PessoaFisica(String nome, String cpfcnpj, double salario) {
        super(nome, cpfcnpj);
        this.salario = salario;
    }

    @Override
    public void getImposto() {
        System.out.println(nome + " com CPF: " + cpfcnpj + " tem salario de " + 
                salario + " e paga um imposto de: " + salario * 0.05);
    }
}
