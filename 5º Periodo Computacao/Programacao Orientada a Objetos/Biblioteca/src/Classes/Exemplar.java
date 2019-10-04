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
public abstract class Exemplar {
    protected String titulo;
    protected int qtdPag;
    protected int anoPub;
    
    public Exemplar() {}
    
    public Exemplar(String titulo, int qtdPag, int anoPub) {
        this.titulo = titulo;
        this.qtdPag = qtdPag;
        this.anoPub = anoPub;
    }
    
    public abstract void mostraDados();
}
