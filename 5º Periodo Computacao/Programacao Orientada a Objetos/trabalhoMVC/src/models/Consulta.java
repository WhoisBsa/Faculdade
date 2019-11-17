/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author matheus
 */
public class Consulta {
    private String data;
    private int paciente_id;

    public Consulta() {
        data = "";
        paciente_id = 0;
    }

    public Consulta(String data, int p) {
        this.data = data;
        this.paciente_id = p;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getP() {
        return paciente_id;
    }

    public void setP(int p) {
        this.paciente_id = p;
    }
    
    
}
