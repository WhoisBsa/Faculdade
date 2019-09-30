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
public abstract class ContaBancaria {
    private int numConta;
    private double saldo;
    
    public ContaBancaria() {}
    
    public ContaBancaria(int numConta, double saldo) {
        this.numConta = numConta;
        this.saldo = saldo;
    }
    
    public abstract String sacar(double valor);
    
    public abstract String depositar(double valor); 
    
    public abstract String transferir(double valor, ContaCorrente cCorrente);
    
    public abstract String transferir(double valor, ContaPoupanca cPoupanca);
    
    public abstract String mostrarDados();

    /**
     * @return the numConta
     */
    public int getNumConta() {
        return numConta;
    }

    /**
     * @param numConta the numConta to set
     */
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
