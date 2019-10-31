/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author matheus
 */
public class Produto {
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs = null;
    
    public void inserir(String marca, String nome, String preco) {
        String sql = "insert into produto(marca, nome, preco) "
                + "values(?, ?, ?)";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, marca);
            pst.setString(2, nome);
            pst.setString(3, preco);
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0) {
                System.out.println("Produto adicionado com sucesso!");
            } else {
                System.out.println("Não foi possível cadastrar o produto!");
            }
        } catch(Exception ex) {
            System.out.println(ex);
        } finally {
            Conector.desconectar(conexao);
        }
    }
    
    public ResultSet litar() {
        String sql = "select * from produto";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            rs = pst.executeQuery();
        } catch(Exception ex) {
            System.out.println(ex);
        } finally {
            return rs;
        }
    }
    
    public void atualizar(String marca, String nome, String preco, int id) {
        String sql = "update produto set marca = ?, nome = ?, preco = ? "
                + "where idproduto = ?";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, marca);
            pst.setString(2, nome);
            pst.setString(3, preco);
            pst.setInt(4, id);
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0) {
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Não foi possível atualizar o produto!");
            }
        } catch(Exception ex) {
            System.out.println(ex);
        } finally {
            Conector.desconectar(conexao);
        }
    }
    
    public void delete(int id) {
        String sql = "delete from produto where idproduto = ?";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0) {
                System.out.println("Produto apagado com sucesso!");
            } else {
                System.out.println("Não foi possível apagar o produto!");
            }
        } catch(Exception ex) {
            System.out.println(ex);
        } finally {
            Conector.desconectar(conexao);
        }
    }
}