/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_db;

import java.sql.ResultSet;

/**
 *
 * @author matheus
 */
public class Aula12_db {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // java.sql.Connection a = Conector.conectar();
        // Conector.desconectar(a);
        
        Produto produto = new Produto();
        
        ResultSet rs = produto.litar();
        
        // produto.atualizar("Motorola", "Moto G", "600", 7);
        produto.delete(6);
        
        try {
            while(rs.next()) {
                String marca = rs.getString("marca");
                String nome = rs.getString("nome");
                String preco = rs.getString("preco");
                
                System.out.println("Marca: " + marca);
                System.out.println("Nome: " + nome);
                System.out.println("Preco: " + preco);
                System.out.println();
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
}
