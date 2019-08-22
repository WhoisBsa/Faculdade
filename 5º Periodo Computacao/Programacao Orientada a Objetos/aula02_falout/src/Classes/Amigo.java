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
public class Amigo {
    
    public Amigo() {
        healt = 100;
    }
    
    private int healt = 100;

    public void atackFriend() {
        healt = healt - 30;
    }
    
    public int getHealt() {
        return healt;
    }
    
    public void setHealt(int healt) {
        this.healt = healt;
    }
}
