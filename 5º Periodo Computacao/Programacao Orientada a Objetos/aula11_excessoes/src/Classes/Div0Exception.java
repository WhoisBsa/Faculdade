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
public class Div0Exception extends Exception {
    @Override
    public String getMessage() {
        return "Não é possível dividir por 0! Insira outro valor.";
    }
}
