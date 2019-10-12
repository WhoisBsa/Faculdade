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
public class Cliente implements Comparable<Cliente> {  
    private String nome;
    private int idade;
    
    public Cliente() {}
    
    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

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
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public int compareTo(Cliente cliente) {
        /*if (this.idade < cliente.getIdade()) {
            return -1;
        } else if (this.idade == cliente.getIdade()) {
            return 0;
        }
        return 1;*/
        return this.nome.compareTo(cliente.getNome());
    }
    
}
