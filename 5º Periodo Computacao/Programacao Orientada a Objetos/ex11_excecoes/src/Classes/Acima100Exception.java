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
public class Acima100Exception extends Exception{
    
    @Override
    public String getMessage() {
        return "Sem números acima de 100! Apenas números de 0 a 100!";
    }
}
