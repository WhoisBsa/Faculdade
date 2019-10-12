/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10_arraylist;

import Classes.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author matheus
 */
public class Aula10_arraylist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
        
        lista.add("Maria");
        lista.add("João");
        lista.add("Jose");
        lista.add(29);
        lista.add(34.2);
        lista.add(new Cliente());
        
        System.out.println(lista);
        
        lista.remove(5);
        System.out.println(lista);
        System.out.println();
        
        lista.add(false);
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Info: " + lista.get(i));
        }
        
        List<String> lista2 = new ArrayList<>();
        
        System.out.println();
        lista2.add("Matheus");
        lista2.add("Rafael");
        lista2.add("Gustavo");
        
        Collections.sort(lista2);
        
        System.out.println(lista2);
        
        List<Cliente> clientes = new ArrayList<>();
        
        clientes.add(new Cliente("Matheus", 19));
        clientes.add(new Cliente("Rafael", 30));
        clientes.add(new Cliente("Hemilio", 31));
        clientes.add(new Cliente("Gustavo", 22));
        
        Collections.sort(clientes);
        
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i).getNome() + ": " + clientes.get(i).getIdade());
        }
    }
    
}
