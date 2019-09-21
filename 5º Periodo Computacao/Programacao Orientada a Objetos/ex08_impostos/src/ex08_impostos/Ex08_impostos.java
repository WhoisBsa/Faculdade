/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex08_impostos;

import Classes.*;

/**
 *
 * @author matheus
 */
public class Ex08_impostos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PessoaFisica pF = new PessoaFisica("Matheus", "12345678910", 3200);
        pF.getImposto();
        
        PequenaEmpresa pE = new PequenaEmpresa("Malak", "16554855987-1", 50000);
        pE.getImposto();
        
        MediaEmpresa mE = new MediaEmpresa("Uber", "96559545987-1", 100000);
        mE.getImposto();
        
        GrandeEmpresa gE = new GrandeEmpresa("Nike", "58754412987-1", 5000000);
        gE.getImposto();
    }
    
}
