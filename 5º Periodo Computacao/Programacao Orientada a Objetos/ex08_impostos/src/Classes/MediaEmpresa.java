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
public class MediaEmpresa extends PessoaJuridica {
    
    public MediaEmpresa() {}
    
    public MediaEmpresa(String nome, String cpfcnpj, double faturamento) {
        super(nome, cpfcnpj, faturamento);
    }
    
    @Override
    public void getImposto() {
        System.out.println(nome + " com CNPJ: " + cpfcnpj + " tem o faturamento de " 
                + faturamento + " e paga um imposto de: " + faturamento * 0.13);

    }
}
