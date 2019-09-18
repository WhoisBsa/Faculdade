/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula07_cadastro;

import Classes.User;
import Views.ViewUserLogin;

/**
 *
 * @author matheus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User users[] = new User[4];
        
        users[0] = new User("matheus", "123");
        users[1] = new User("rafael", "456");
        users[2] = new User("gustavo", "789");
        users[3] = new User("hemilio", "147");
        
        ViewUserLogin userLogin = new ViewUserLogin(users);
        userLogin.setVisible(true);
    }
    
}
