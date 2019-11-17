/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author matheus
 */
public class Paciente {
    private String nome;
    private String cpf;
    private int idade;
    private String genero;

    public Paciente() {
        this.nome = "";
        this.cpf = "";
        this.idade = 0;
        this.genero = "";
    }

    public Paciente(String nome, String cpf, int idade, String genero) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
