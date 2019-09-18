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
public class Client {
    private String name;
    private String cpf;
    private String address;
    
    public Client() {}
    
    public Client(String name, String cpf, String address) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }
    
    public String showSearchData() {
        return "Name: " + this.name + "\n"
                + "Cpf: " + this.cpf + "\n"
                + "Address: " + this.address
                + "\n";
    }
    
    public String showAllData() {
        return "Name: " + this.name + "<br>"
                + "Cpf: " + this.cpf + "<br>"
                + "Address: " + this.address + "<br>"
                + "<br>";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the password to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
