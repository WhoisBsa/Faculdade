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
public class Revista extends Exemplar implements Emprestar{
    private String categoria;
    private int mesPub;
    private String dataEntrega;
    private Editora editora;
    
    public Revista(){}
    
    public Revista(String titulo, int qtdPag, int anoPub, String categoria, 
            int mesPub, String dataEntrega, Editora editora) {
        super(titulo, qtdPag, anoPub);
        this.categoria = categoria;
        this.mesPub = mesPub;
        this.dataEntrega = dataEntrega;
        this.editora = editora;
    }
    
    @Override
    public void mostraDados() {
        System.out.println("Título: " + titulo);
        System.out.println("Páginas: " + qtdPag);
        System.out.println("Ano: " + anoPub);
        System.out.println("Mes: " + getMesPub());
        System.out.println("Categoria: " + getCategoria());
    }

    @Override
    public void emprestar(String dataEntrega) {
        System.out.println("A revista está emprestada até: " + dataEntrega);
    }
    
    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the mesPub
     */
    public int getMesPub() {
        return mesPub;
    }

    /**
     * @param mesPub the mesPub to set
     */
    public void setMesPub(int mesPub) {
        this.mesPub = mesPub;
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

