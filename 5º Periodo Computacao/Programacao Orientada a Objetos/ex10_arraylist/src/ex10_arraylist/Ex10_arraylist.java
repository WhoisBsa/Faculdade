/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex10_arraylist;

import Classes.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author matheus
 */
public class Ex10_arraylist {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Produto> produto = new ArrayList<>();
        
        produto.add(new Produto("Notebook", "HP", 6000.00));
        produto.add(new Produto("Celular", "Xiaomi", 600.00));
        produto.add(new Produto("Headfone", "Sony", 66.85));
        produto.add(new Produto("Mouse", "Razer", 66.89));
        produto.add(new Produto("PenDrive", "Sandisk", 44.99));
        produto.add(new Produto("Tablet", "Accer", 309.99));
        
        Scanner input = new Scanner(System.in);

        int op = -1;
        
        while(op != 0) {
            String resultado = "";
            String r = "";
            String nome = "";
            String marca = "";
            double valor = 0;
            r = "";
            
            System.out.println("Lista de Produtos\n");
            for (int i = 0; i < produto.size(); i++) {
                System.out.printf("%-20s", produto.get(i).getNome());
            }
            System.out.println();
            for (int i = 0; i < produto.size(); i++) {
                System.out.printf("%-20s", produto.get(i).getMarca());
            }
            System.out.println();
            for (int i = 0; i < produto.size(); i++) {
                System.out.printf("%-20s", produto.get(i).getValor());
            }
            System.out.println("\n");
            
            System.out.println("Menu");
            System.out.println("1 - Organizar produtos");
            System.out.println("2 - Pesquisar produto");
            System.out.println("3 - Alterar produto");
            System.out.println("4 - Remover produto");
            System.out.println("0 - Sair");
            
            System.out.print("Opção: ");
            op = input.nextInt();
            
            switch(op) {   
                case 1:
                    System.out.println("Qual tipo de ordenação?");
                    System.out.println("1 - Nome; 2 - Valor Crescente; 3 - Valor Decrescente");
                    resultado = input.next();
                    switch(Integer.parseInt(resultado)) {
                        case 1:       
                            Collections.sort(produto, new Comparador(Comparador.nome));
                            System.out.println();
                            System.out.println("Por Nome\n");
                            for (int i = 0; i < produto.size(); i++) {
                                System.out.printf("%s %s %s\n", produto.get(i).getNome(), 
                                        produto.get(i).getMarca(), produto.get(i).getValor());
                            }
                            break;
                            
                        case 2:
                            Collections.sort(produto, new Comparador(Comparador.marca));
                            System.out.println();
                            System.out.println("Por Preço Crescente\n");
                            for (int i = 0; i < produto.size(); i++) {
                                System.out.printf("%s %s %s\n", produto.get(i).getNome(), 
                                        produto.get(i).getMarca(), produto.get(i).getValor());
                            }
                            break;
                            
                        case 3:
                            Collections.sort(produto, new Comparador(Comparador.valor));
                            System.out.println();
                            System.out.println("Por Preço Decrescente\n");
                            for (int i = 0; i < produto.size(); i++) {
                                System.out.printf("%s %s %s\n", produto.get(i).getNome(), 
                                        produto.get(i).getMarca(), produto.get(i).getValor());
                            }
                            break;
                    }
                    System.out.println();
                    break;
        
                case 2:
                    System.out.print("Nome ou marca do produto: ");
                    resultado = input.next();
                     r = "";
                    for (int i = 0; i < produto.size(); i++) {
                        if(produto.get(i).getNome().equals(resultado) || produto.get(i).getMarca().equals(resultado)) {
                            r += ("\n" + produto.get(i).getNome() + "\n" 
                                    + produto.get(i).getMarca() + "\n" 
                                    + produto.get(i).getValor() + "\n");
                        }
                    }
                    if(r.isBlank()) {
                        System.out.println("\nNenhum Produto encontrado!\n");
                    } else {
                        System.out.println(r);
                    }
                    break;
                    
                case 3:
                    System.out.print("Nome do produto: ");
                    resultado = input.next();
                    for (int i = 0; i < produto.size(); i++) {
                        if(produto.get(i).getNome().equals(resultado)) {
                            System.out.print("Nome: ");
                            nome = input.next();
                            System.out.print("Marca: ");
                            marca = input.next();
                            System.out.print("Valor: ");
                            valor = input.nextDouble();
                            
                            produto.get(i).setNome(nome);
                            produto.get(i).setMarca(marca);
                            produto.get(i).setValor(valor);
                            
                            r += ("\n" + produto.get(i).getNome() + "\n" 
                                    + produto.get(i).getMarca() + "\n" 
                                    + produto.get(i).getValor() + "\n");
                        }
                    }
                    if(r.isBlank()) {
                        System.out.println("\nNenhum Produto encontrado!");
                    } else {
                        System.out.println(r);
                    }
                    break;
                    
                case 4:
                    System.out.print("Nome ou marca do produto: ");
                    resultado = input.next();
                    r = "";
                    for (int i = 0; i < produto.size(); i++) {
                        if(produto.get(i).getNome().equals(resultado)) {
                            produto.remove(i);
                            r += "Produto removido!";
                        }
                    }
                    if(r.isBlank()) {
                        System.out.println("\nNenhum Produto encontrado!");
                    } else {
                        System.out.println(r);
                    }
                    break;   
            }
            System.out.println("\nPress ENTER to continue...");
            System.in.read();
        }
    } 
}
