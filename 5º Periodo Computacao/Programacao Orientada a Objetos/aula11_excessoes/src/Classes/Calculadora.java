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
public class Calculadora {
    public double dividir(double a, double b) throws Div0Exception {
        
        if(b == 0)
            throw new Div0Exception();
        
        double resultado = a/b;
        
        return resultado;
    }
}
