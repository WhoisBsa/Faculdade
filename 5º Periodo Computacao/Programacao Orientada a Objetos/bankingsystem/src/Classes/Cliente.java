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
public class Cliente {
    
    // Attributes
    private String name, cpf_cnpj, accountNumber, address;
    private int typeCliente, age;  // tipo de cliente: 0 física, 1 jurídica
    private double cash;
    //
    
    
    // Contructor
    public Cliente(String name, String cpf_cnpj, 
            int typeCliente, String accountNumber) {
        this.name = name;
        this.cpf_cnpj = cpf_cnpj;
        this.typeCliente = typeCliente;
        this.accountNumber = accountNumber;
    }
    //
    
    // Get
    public String getName() {
        return name;
    }
    
    public String getCpfCnpj() {
        return cpf_cnpj;
    }
    
    public int getTypeCliente() {
        return typeCliente;
    }
    
    public String getAccount() {
        return accountNumber;
    }
    
    public double getCash() {
        return cash;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getAge() {
        return age;
    }
    //
    
    // Set
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCpfCnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }
    
    public void setTypeCliente(int tcliente) {
        this.typeCliente = tcliente;
    }
    
    public void setAccount(String account) {
        this.accountNumber = account;
    }
    
    public void setCash(double cash) {
        this.cash = cash;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    //
    
    // Methods
    public void checkCash() {
        System.out.println("Name: " + this.name);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Cash: " + this.cash);
    }
    
    public void checkCliente() {
        System.out.println("Name: " + this.name);
        System.out.println("Account Number: " + this.accountNumber);
    }
    
    public void withdrawCash(double value) {
        if(value <= this.cash){
            this.cash -= value;
            System.out.println("Successful withdrawal!");
            System.out.println("Your new balance is: " + this.cash);
        } else {
            System.out.println("Insufficient funds. Please deposit or choose a smaller amount.");
        }
    }
    
    public void depositCash(double value, Cliente cx) {
        cx.cash += value;
        System.out.println("\nSuccessful deposit!");
    }    
    
    public void transferCash(double value, Cliente cx) {
        if(value <= this.cash){
            this.cash -= value;
            cx.cash += value;
            System.out.println("\nSuccessful transfer!");
            System.out.println("Your new balance is: " + this.cash);
        } else {
            System.out.println("\nInsufficient funds. Please deposit or choose a smaller amount.");
        }    
    }
    //
}
