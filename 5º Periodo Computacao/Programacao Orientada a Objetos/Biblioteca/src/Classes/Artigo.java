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
public class Artigo extends Exemplar {
    private String nomeConf;
    
    
    public Artigo() {}
    
    public Artigo(String titulo, int qtdPag, int anoPub, String nomeConf) {
        super(titulo, qtdPag, anoPub);
        this.nomeConf = nomeConf;
    }

    @Override
    public void mostraDados() {
        System.out.println("Título: " + titulo);
        System.out.println("Páginas: " + qtdPag);
        System.out.println("Ano: " + anoPub);
        System.out.println("Conferência: " + nomeConf);
    }
    
    /**
     * @return the nomeConf
     */
    public String getNomeConf() {
        return nomeConf;
    }

    /**
     * @param nomeConf the nomeConf to set
     */
    public void setNomeConf(String nomeConf) {
        this.nomeConf = nomeConf;
    }
    
}
