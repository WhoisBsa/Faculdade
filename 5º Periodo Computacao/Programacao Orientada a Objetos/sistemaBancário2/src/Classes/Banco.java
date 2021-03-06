/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author matheus
 */
public class Banco {
    private ContaCorrente[] contaCorrente = new ContaCorrente[10];
    private ContaPoupanca[] contaPoupanca = new ContaPoupanca[10];
    private int posCorrente = 0, posPoupanca = 0;
    
    public String inserir(ContaCorrente contaCorrente) {
        this.contaCorrente[posCorrente] = new ContaCorrente(contaCorrente.getNumConta(), 
                contaCorrente.getSaldo());
        posCorrente++;
        
        return "Nova conta corrente inserida com sucesso!!!";
    }
    
    public String inserir(ContaPoupanca contaPoupanca) {
        this.contaPoupanca[posPoupanca] = new ContaPoupanca(contaPoupanca.getNumConta(), 
                contaPoupanca.getSaldo());
        posPoupanca++;
        
        return "Nova conta poupança inserida com sucesso!!!";
    }
    
    public ContaCorrente procurarConta(int numConta, ContaCorrente contaCorrente) {
        for(int i = 0; i < posCorrente; i++) {
            if(this.contaCorrente[i].getNumConta() == numConta) {
                return this.contaCorrente[i];
            }
        }
        return null;
    }
    
    public ContaPoupanca procurarConta(int numConta, ContaPoupanca contaPoupanca) {
        for(int i = 0; i < posPoupanca; i++) {
            if(this.contaPoupanca[i].getNumConta() == numConta) {
                return this.contaPoupanca[i];
            }
        }
        return null;
    }
    
    public ContaCorrente remove(int numConta, ContaCorrente cC) {
        for(int i = 0; i < posCorrente; i++) {
            if(this.contaCorrente[i].getNumConta() == numConta) {
                contaCorrente[i] = null;
                return null;
            }
        }
        return contaCorrente[0];   
    }
    
    public ContaPoupanca remove(int numConta, ContaPoupanca cP) {
        for(int i = 0; i < posPoupanca; i++) {
            if(this.contaPoupanca[i].getNumConta() == numConta) {
                contaPoupanca[i] = null;
                return this.contaPoupanca[i];
            }
        }
        return contaPoupanca[0];   
    }
}
