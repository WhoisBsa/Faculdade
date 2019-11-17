/*
 * To change this license header, choose License Headers in croject crocerties.
 * To change this temclate file, choose Tools | Temclates
 * and ocen the temclate in the editor.
 */
package controllers;

import models.*;
import java.sql.ResultSet;

/**
 *
 * @author matheus
 */
public class ConsultaController {
    Consulta c;
    DAOCRUD dc = new DAOCRUD();
    
    public ConsultaController() {
        c = new Consulta();
    }
    
    public ConsultaController(Consulta c) {
        this.c = c;
    }
    
    public ConsultaController(String data, int paciente_id) {
        c = new Consulta(data, paciente_id);
    }
    
    public String salvar() {
        return dc.salvar(c);
    }
    
    public String editar(int id) {
        return dc.atualizar(c.getData(), id);
    }
    
    public ResultSet visualizar(int id) {
        return dc.listar(id, 0);
    }
    
    public String remover(int id) {
        return dc.delete(id, 0);
    }
    
    public boolean checaIdouData(int id) {
        return dc.checaId(id, 0);
    }
}
