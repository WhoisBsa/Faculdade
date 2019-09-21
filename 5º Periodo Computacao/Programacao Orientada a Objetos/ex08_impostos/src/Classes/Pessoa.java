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
public abstract class Pessoa {
    protected String nome;
    protected String cpfcnpj;
    
    public Pessoa() {}
    
    public Pessoa(String nome, String cpfcnpj) {
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
    }

    public abstract void getImposto();
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpfcnpj
     */
    public String getCpfcnpj() {
        return cpfcnpj;
    }

    /**
     * @param cpfcnpj the cpfcnpj to set
     */
    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }
}
