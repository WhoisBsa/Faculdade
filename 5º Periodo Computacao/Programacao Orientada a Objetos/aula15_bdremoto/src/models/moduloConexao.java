/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author matheus
 */
public class moduloConexao {
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://172.19.17.88/bdremoto";
    public static final String user = "root";
    public static final String psswd = "toor";
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public static java.sql.Connection conectar() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, psswd);
            
        } catch(Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public static void desconectar(java.sql.Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void salvar() {
        String sql = "insert into produto(marca, nome, preco) "
                + "values(?, ?, ?)";
        
        conexao = this.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, "Sony");
            pst.setString(1, "Palystation");
            pst.setString(1, "2000");
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0) {
                System.out.println("Cliente cadastrado com sucesso!");
            } else {
                System.out.println("Não foi possível cadastrar o cliente!");
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            this.desconectar(conexao);
        }
    }
}
