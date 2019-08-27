/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import Classes.Cliente;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author matheus
 */
public class Bankingsystem {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        // Create objects
        Cliente c1 = new Cliente("Matheus", "11872233344", 0, "1234-1");
        Cliente c2 = new Cliente("Lucas", "13165733344", 0, "1235-1");
        Cliente c3 = new Cliente("Gustavo", "11122237894", 0, "1258-1");
        Cliente c4 = new Cliente("Hemilio", "45722233344", 0, "1297-1");
        Cliente c5 = new Cliente("Rafael", "15162933344", 0, "1354-1");
        //

        // Set cash
        c1.setCash(1000.01);
        c2.setCash(20000.00);
        c3.setCash(5000.45);
        c4.setCash(800.90);
        c5.setCash(1276.87);
        //

        // Create scanner to enter values
        Scanner input = new Scanner(System.in);
        int op, opCliente;
        double value;
        //
        
        // Menu
        while(true) {
            System.out.println("\nWelcome to JavaBank!");
            System.out.println("Choose an Option");
            System.out.println("1 - Check Cash");
            System.out.println("2 - Withdraw Cash");
            System.out.println("3 - Deposit");
            System.out.println("4 - Transfer");
            System.out.println("5 - Exit\n");
            System.out.print("Option: ");
            op = input.nextInt();
            System.out.println("");
            
            if(op == 5)
                break;
            
            while(op < 1 || op > 5) {
                System.out.println("Invalid option. Choose one of the above!");
                System.out.print("Option: ");
                op = input.nextInt();
                System.out.println("");
            } 
      
            switch(op) {
                case 1:
                    c1.checkCash();
                    break;
                
                case 2:
                    System.out.print("Amount to be withdrawn: ");
                    value = input.nextDouble();
                    c1.withdrawCash(value);
                    break;
                
                case 3:
                    System.out.print("Deposit amount: ");
                    value = input.nextDouble();
                    
                    // Choose Cliente
                    System.out.println("\nChoose a client to deposit\n");
                    
                    System.out.println("1 - Client 1");
                    c1.checkCliente();
                    
                    System.out.println("\n2 - Client 2");
                    c2.checkCliente();
                    
                    System.out.println("\n3 - Client 3");
                    c3.checkCliente();
                    
                    System.out.println("\n4 - Client 4");
                    c4.checkCliente();
                    
                    System.out.println("\n5 - Client 5");
                    c5.checkCliente();
                    
                    System.out.print("\nSelect: ");
                    opCliente = input.nextInt();
                    
                    switch(opCliente) {
                        case 1:
                            c1.depositCash(value, c1);
                            break;
                        case 2:
                            c1.depositCash(value, c2);
                            break;
                        case 3:
                            c1.depositCash(value, c3);
                            break;
                        case 4:
                            c1.depositCash(value, c4);
                            break;
                        case 5:
                            c1.depositCash(value, c5);
                            break;
                    }
                    //
                    
                    break;
                    
                case 4:
                    System.out.print("Transfer amount: ");
                    value = input.nextDouble();
                    
                    // Choose Cliente
                    System.out.println("\nChoose a client to transfer\n");
                    
                    System.out.println("1 - Client 1");
                    c1.checkCliente();
                    
                    System.out.println("\n2 - Client 2");
                    c2.checkCliente();
                    
                    System.out.println("\n3 - Client 3");
                    c3.checkCliente();
                    
                    System.out.println("\n4 - Client 4");
                    c4.checkCliente();
                    
                    System.out.println("\n5 - Client 5");
                    c5.checkCliente();
                    
                    System.out.print("\nSelect: ");
                    opCliente = input.nextInt();
                    
                    switch(opCliente) {
                        case 1:
                            c1.transferCash(value, c1);
                            break;
                        case 2:
                            c1.transferCash(value, c2);
                            break;
                        case 3:
                            c1.transferCash(value, c3);
                            break;
                        case 4:
                            c1.transferCash(value, c4);
                            break;
                        case 5:
                            c1.transferCash(value, c5);
                            break;
                    }
                    //
                    
                    break;
            }
            System.out.println("\nPress ENTER to continue...");
            System.in.read();
        }
    }
    
}
