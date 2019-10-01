/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class ContaCorrente extends ContaBancaria{
    private double taxaDeOperacao = 0.01;
    
    public ContaCorrente() {}
    
    public ContaCorrente(int numConta, double saldo) {
        super(numConta, saldo);
    }

    
    @Override
    public String sacar(double valor) {
        if(valor > this.getSaldo())
            return "Saldo insuficiente!!!";
        else {
            this.setSaldo(this.getSaldo() - valor - valor * (getTaxaDeOperacao()/100));
            return "Saque realizado com sucesso!";
        }
    }
    
    @Override
    public String depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor - valor * (getTaxaDeOperacao()/100));
        return "Deposito realizado com sucesso!";
    }
    
    @Override
    public String transferir(double valor, ContaCorrente cCorrente) {
        if(valor > this.getSaldo())
            return "Saldo insuficiente!!!";
        else {
            this.sacar(valor);
            cCorrente.depositar(valor);
            return "Transferencia realizada com sucesso!";
        }
    }
    
    @Override
    public String transferir(double valor, ContaPoupanca cPoupanca) {
        if(valor > this.getSaldo())
            return "Saldo insuficiente!!!";
        else {
            this.sacar(valor);
            cPoupanca.depositar(valor);
            return "Transferencia realizada com sucesso!";
        }
    }
    
    @Override
    public String mostrarDados() {
        return "Numero da conta: " + this.getNumConta()
                + "\nSaldo: " + String.format("%.2f", this.getSaldo())
                + "\nTaxa de operação: " + getTaxaDeOperacao() + "%";
    }

    /**
     * @return the taxaDeOperacao
     */
    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    /**
     * @param taxaDeOperacao the taxaDeOperacao to set
     */
    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }
}
