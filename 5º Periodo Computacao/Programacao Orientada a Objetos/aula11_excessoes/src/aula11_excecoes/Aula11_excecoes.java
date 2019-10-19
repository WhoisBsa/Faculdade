/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_excecoes;

import Classes.*;

/**
 *
 * @author matheus
 */
public class Aula11_excecoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        Calculadora calculadora = new Calculadora();
        
        try {
            calculadora.dividir(1, 0);
        } catch(Div0Exception e) {
            System.out.println(e.getMessage());
        }
        
        carrinho.produtos[0] = new Produto("Xbox One", 1400);
        carrinho.produtos[1] = new Produto("PS4", 2000);
        carrinho.produtos[2] = new Produto("Nintendo Switch", 2800);
        
        boolean excecao = false;
        
        /* try {
            // carrinho.produtos[10].getNome();
            carrinho.listar();
        } catch (NullPointerException ex) {
            for (int i = 0; i < 10; i++) {
                if (carrinho.produtos[i] == null) {
                    carrinho.produtos[i] = new Produto();
                }
            }
            System.out.println("Gerou excessão: " + ex);
            
            carrinho.listar();
            
            excecao = true;
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("O índice máximo de produtos é 9");
            
            excecao = true;
        } finally {
            if (excecao == true) {
                System.out.println("Código gerou exceção!");
            } else {
                System.out.println("Código não gerou exceção!");
            }
        } */
    }
    
}
