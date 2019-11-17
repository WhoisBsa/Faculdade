/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.*;
import java.sql.ResultSet;


/**
 *
 * @author matheus
 */
public class PacienteController {
    Paciente p;
    DAOCRUD dc = new DAOCRUD();
    
    public PacienteController() {
        p = new Paciente();
    }
    
    public PacienteController(Paciente p) {
        this.p = p;
    }
    
    public PacienteController(String nome, String cpf, int idade, String genero) {
        p = new Paciente(nome, cpf, idade, genero);
    }
    
    public String salvar() {
        return dc.salvar(p);
    }
    
    public String editar(int id) {
        return dc.atualizar(p.getNome(), p.getCpf(), p.getIdade(), p.getGenero(), id);
    }
    
    public ResultSet visualizar(int id) {
        return dc.listar(id, 1);
    }
    
    public String remover(int id) {
        return dc.delete(id, 1);
    }
    
    public boolean checaIdouData(int id) {
        return dc.checaId(id, 1);
    }
}
