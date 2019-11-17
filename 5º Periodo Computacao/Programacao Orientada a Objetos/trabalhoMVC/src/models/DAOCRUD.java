/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matheus
 */
public class DAOCRUD {
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/exercicioMvc";
    public static final String user = "root";
    public static final String psswd = "root";
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public static java.sql.Connection conectar() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, psswd);
            
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public static void desconectar(java.sql.Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);;
            }
        }
    }
    
    public String salvar(Paciente p) {
        String sql = "insert into paciente(nome, cpf, idade, genero) "
                + "values(?, ?, ?, ?)";
        
        conexao = DAOCRUD.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, p.getNome());
            pst.setString(2, p.getCpf());
            pst.setInt(3, p.getIdade());
            pst.setString(4, p.getGenero());
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0) {
                return "Paciente cadastrado com sucesso!";
            } else {
                return "Não foi possível cadastrar o paciente!";
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            DAOCRUD.desconectar(conexao);
        }
        return null;
    }
    
    public String salvar(Consulta c) {
        String sql = "insert into consulta(data, paciente_id) "
                + "values(?, ?)";
        
        conexao = DAOCRUD.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, c.getData());
            pst.setInt(2, c.getP());
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0) {
                return "Consulta cadastrada com sucesso!";
            } else {
                return "Não foi possível cadastrar a consulta!";
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            DAOCRUD.desconectar(conexao);
        }
        return null;
    }
    
    public boolean checaId(int id, int tipo){
        String sql = null;
        if(tipo == 1)
            sql = "select * from paciente where id = ?";
        else
            sql = "select * from consulta where id = ?";
        
        conexao = DAOCRUD.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            DAOCRUD.desconectar(conexao);
            return false;
        } finally {
            DAOCRUD.desconectar(conexao);
        }
    }
    
    public ResultSet listar(int id, int tipo) {
       String sql = null;
        if(tipo == 1)
            sql = "select * from paciente left join consulta on "
                    + "paciente.id = consulta.paciente_id where paciente.id = ?";
        else
            sql = "select * from paciente left join consulta on "
                    + "paciente.id = consulta.paciente_id where consulta.id = ?";
        
        conexao = DAOCRUD.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            return rs;
        }
    }
    
    
    public String delete(int id, int tipo) {
        String sql = null;
        if(tipo == 1)
            sql = "delete from paciente where id = ?";
        else
            sql = "delete from consulta where id = ?";
        
        conexao = DAOCRUD.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0)
                return "Apagado com sucesso!";
            else
                return "Id inexistente!";
            
        } catch(SQLException ex) {
            System.out.println(ex);;
        } finally {
            DAOCRUD.desconectar(conexao);
        }
        return null;
    }
    
    public String atualizar(String nome, String cpf, int idade, String genero, int id) {
        String sql = "update paciente set nome = ?, cpf = ?, idade = ?, genero = ? "
                + "where id = ?";
        
        conexao = DAOCRUD.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setInt(3, idade);
            pst.setString(4, genero);
            pst.setInt(5, id);
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0)
                return "Cliente atualizado com sucesso!";
            else
                return "Não foi possível atualizar este cliente!";
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            DAOCRUD.desconectar(conexao);
        }
        return null;
    }
    
    public String atualizar(String data, int id) {
        String sql = "update consulta set data = ? where id = ?";
        
        conexao = DAOCRUD.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, data);
            pst.setInt(1, id);
            
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0)
                return "Cliente atualizado com sucesso!";
            else
                return "Não foi possível atualizar este cliente!";
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            DAOCRUD.desconectar(conexao);
        }
        return null;
    }
}
