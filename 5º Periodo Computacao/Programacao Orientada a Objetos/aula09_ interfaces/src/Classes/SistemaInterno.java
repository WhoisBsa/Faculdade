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
public class SistemaInterno {
    public void login(Autenticavel a) {
        if(a.autentica(a.getSenha()))
            System.out.println("Login ok!");
        else
            System.out.println("Login false!");
    }
}
