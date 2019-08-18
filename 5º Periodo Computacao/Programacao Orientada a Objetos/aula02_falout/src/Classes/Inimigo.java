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
public class Inimigo {
    public int healt = 100;
    
    public void atack(int bodypart) {
        if(bodypart == 1) {
            this.healt = this.healt - 100;
            if(!this.isAlive())
                System.out.println("HP: " + this.healt);
            else
                System.out.println("YOU ROCK!!!");
        }
        else if(bodypart == 2) {
            this.healt = this.healt - 50;
            if(!this.isAlive())
                System.out.println("HP: " + this.healt);
            else
                System.out.println("YOU ROCK!!!");
        }
        else if(bodypart == 3) {
            this.healt = this.healt - 20;
            if(!this.isAlive())
                System.out.println("HP: " + this.healt);
            else
                System.out.println("YOU ROCK!!!");
        }
        else if(bodypart == 4) {
            this.healt = this.healt - 10;
            if(!this.isAlive())
                System.out.println("HP: " + this.healt);
            else
                System.out.println("YOU ROCK!!!");
        }
    }
    
    public boolean isAlive() {
        return this.healt <= 0;
    }
    
    public void headShot() {
        this.healt = this.healt - 100;
        if(!this.isAlive())
            System.out.println("HP: " + this.healt);
        else
            System.out.println("YOU ROCK!!!");
    }
    
    public void body() {
        this.healt = this.healt - 30;
        if(!this.isAlive())
            System.out.println("HP: " + this.healt);
        else
            System.out.println("YOU ROCK!!!");
    }
    
    public void arm() {
        this.healt = this.healt - 10;
        if(!this.isAlive())
           System.out.println("HP: " + this.healt);
        else
            System.out.println("YOU ROCK!!!");
    }
    
    public void leg() {
        this.healt = this.healt - 20;
        if(!this.isAlive())
            System.out.println("HP: " + this.healt);
        else
            System.out.println("YOU ROCK!!!");
    }
}
