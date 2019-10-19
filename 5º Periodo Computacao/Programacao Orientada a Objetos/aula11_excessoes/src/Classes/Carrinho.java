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
public class Carrinho {
    public Produto[] produtos = new Produto[10];
    
    public Carrinho() {
        for (int i = 0; i < 10; i++) {
            produtos[i] = new Produto();
        }
    }
    
    public void listar() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Produto: " + produtos[i].getNome());
            System.out.println("Preco: " + produtos[i].getPreco());
            System.out.println();
        }
    }
}
