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
public class Livro extends Exemplar implements Emprestar{
    private String dataEntrega; 
    private Editora editora;
    
    public Livro() {}
    
    public Livro(String titulo, int qtdPag, int anoPub, String dataEntrega, Editora Editora) {
        super(titulo, qtdPag, anoPub);
        this.dataEntrega = dataEntrega;
        this.editora = editora;
    }

    @Override
    public void mostraDados() {
        System.out.println("Título: " + titulo);
        System.out.println("Páginas: " + qtdPag);
        System.out.println("Ano: " + anoPub);
    }
    
    @Override
    public void emprestar(String dataEntrega) {
        System.out.println("O livro está emprestado até: " + dataEntrega);
    }
    
    /**
     * @return the dataEntrega
     */
    public String getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the editora
     */
    public Editora getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
}
