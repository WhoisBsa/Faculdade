/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Comparator;

/**
 *
 * @author matheus
 */
public class Comparador implements Comparator<Produto> {
    public static final int nome = 1;
    public static final int marca = 2;
    public static final int valor = 3;
    private int tipoComparacao = 0;
    
    public Comparador(int tipoComparacao) {
        this.tipoComparacao = tipoComparacao;
    }
    
    @Override
    public int compare(Produto produto1, Produto produto2) {
        int resultado = 0;
        
        switch(this.tipoComparacao) {
            case 1:
                return produto1.getNome().compareTo(produto2.getNome());
            case 2:
                if (produto1.getValor() < produto2.getValor()) 
                    return -1;
                if (produto1.getValor() > produto2.getValor()) 
                    return 1;
                return 0;
            case 3:
                if (produto1.getValor() < produto2.getValor()) 
                    return 1;
                if (produto1.getValor() > produto2.getValor()) 
                    return -1;
                return 0;
            default:
                throw new RuntimeException("Opção invalida");
        } 
    }
}
