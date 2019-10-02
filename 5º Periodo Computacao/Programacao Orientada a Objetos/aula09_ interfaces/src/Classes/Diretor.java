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
public class Diretor extends Funcionario implements Autenticavel {
    private int senha;
    
    public Diretor(String nome, int senha) {
        super(nome);
        this.senha = senha;
    }
    
    @Override
    public boolean autentica(int senha) {
        return 123 == senha;
    }

    /**
     * @return the senha
     */
    @Override
    public int getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(int senha) {
        this.senha = senha;
    }
}
