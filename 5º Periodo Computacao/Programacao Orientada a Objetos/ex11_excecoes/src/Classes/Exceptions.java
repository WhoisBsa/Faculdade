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
public class Exceptions {
    public void excecoes(double nota) throws Acima100Exception, NumeroNegativoException {
        if(nota < 0) {
            throw new NumeroNegativoException();
        }
        if(nota > 100) {
            throw new Acima100Exception();
        }
    }
}
