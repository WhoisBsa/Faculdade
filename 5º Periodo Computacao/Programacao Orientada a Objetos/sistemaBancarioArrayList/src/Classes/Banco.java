/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public class Banco {
    private ArrayList<ContaCorrente> contaCorrente = new ArrayList<>();
    private ArrayList<ContaPoupanca> contaPoupanca = new ArrayList<>();
    private int posCorrente = 0, posPoupanca = 0;
    
    public String inserir(ContaCorrente contaCorrente) {
        this.contaCorrente.add(new ContaCorrente(contaCorrente.getNumConta(), 
                contaCorrente.getSaldo()));
        
        return "Nova conta corrente inserida com sucesso!!!";
    }
    
    public String inserir(ContaPoupanca contaPoupanca) {
        this.contaPoupanca.add(new ContaPoupanca(contaPoupanca.getNumConta(), 
                contaPoupanca.getSaldo()));
        
        return "Nova conta poupança inserida com sucesso!!!";
    }
    
    public ContaCorrente procurarConta(int numConta, ContaCorrente contaCorrente) {
        for(int i = 0; i < posCorrente; i++) {
            if(this.contaCorrente.get(i).getNumConta() == numConta) {
                return this.contaCorrente.get(i);
            }
        }
        return null;
    }
    
    public ContaPoupanca procurarConta(int numConta, ContaPoupanca contaPoupanca) {
        for(int i = 0; i < posPoupanca; i++) {
            if(this.contaPoupanca.get(i).getNumConta() == numConta) {
                return this.contaPoupanca.get(i);
            }
        }
        return null;
    }
}
