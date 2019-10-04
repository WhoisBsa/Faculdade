/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import Classes.*;

/**
 *
 * @author matheus
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Editora pearson = new Editora("Pearson Universidades", "São Paulo");
        Editora scientific = new Editora("Scientific American", "Nova Iorque");
        
        Livro livro = new Livro("Java: Como Programar", 968, 2015, "04/10/2019", pearson);
        
        Revista revista = new Revista("O primeiro mapa 3D da Via Láctea", 42, 2019, 
                "Ciência", 07, "12/10/2019", scientific);
        
        Artigo artigo = new Artigo("Recollective experience in word and nonword recognition", 
                7, 1990, "Java Conference");
        
        livro.emprestar(livro.getDataEntrega());
        livro.mostraDados();
        System.out.println("");
        
        revista.emprestar(revista.getDataEntrega());
        revista.mostraDados();
        System.out.println("");
        
        artigo.mostraDados();
    }
    
}
