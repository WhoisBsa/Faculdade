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
public class ContaPoupanca extends ContaBancaria {
    private double limite = 100;
    
    public ContaPoupanca() {}
    
    public ContaPoupanca(int numConta, double saldo, double limite) {
        super(numConta, saldo);
        this.limite = limite;
    }
    
    public ContaPoupanca(int numConta, double saldo) {
        super(numConta, saldo);
    }
    
    @Override
    public String sacar(double valor) {
        this.setSaldo(this.getSaldo() + getLimite());
        if(valor > this.getSaldo())
            return "Saldo insuficiente!!!";
        else {
            this.setSaldo(this.getSaldo() - valor);
            return "Saque realizado com sucesso! Saldo atual de R$" + String.format("%.2f", getSaldo());
        }
    }
    
    @Override
    public String depositar(double valor) {
        this.setSaldo(this.getSaldo() + getLimite() + valor);
        return "Deposito realizado com sucesso! Saldo atual de R$" + String.format("%.2f", getSaldo());
    }
    
    @Override
    public String transferir(double valor, ContaCorrente cCorrente) {
        if(valor > this.getSaldo())
            return "Saldo insuficiente!!!";
        else {
            this.sacar(valor);
            cCorrente.depositar(valor);
            return "Transferencia realizada com sucesso! Saldo atual de R$" + String.format("%.2f", getSaldo());
        }
    }
    
    @Override
    public String transferir(double valor, ContaPoupanca cPoupanca) {
        if(valor > this.getSaldo())
            return "Saldo insuficiente!!!";
        else {
            this.sacar(valor);
            cPoupanca.depositar(valor);
            return "Transferencia realizada com sucesso! Saldo atual de R$" + String.format("%.2f", getSaldo());
        }
    }
    
    @Override
    public String mostrarDados() {
        return "Numero da conta: " + this.getNumConta()
                + "\nSaldo: " + this.getSaldo()
                + "\nLimite: " + this.getLimite();
    }

    /**
     * @return the limite
     */
    public double getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }
}
