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
    
    public Inimigo() {
        head = 100;
        arms = 100;
        legs = 100;
        healt = 100;
    }
    
    public int head = 100;
    public int arms = 100;
    public int legs = 100;
    public int healt = 100;

    public Inimigo(int head, int arms, int legs, int healt) {
        this.head = head;
        this.arms = arms;
        this.legs = legs;
        this.healt = healt;
    }
        
    public void atack(int bodypart) {
        switch (bodypart) {
            case 1:
                this.healt = this.healt - 100;
                if(!this.isAlive())
                    System.out.println("HP: " + this.healt);
                else
                    System.out.println("YOU ROCK!!!");
                break;
            case 2:
                this.healt = this.healt - 50;
                if(!this.isAlive())
                    System.out.println("HP: " + this.healt);
                else
                    System.out.println("YOU ROCK!!!");
                break;
            case 3:
                this.healt = this.healt - 20;
                if(!this.isAlive())
                    System.out.println("HP: " + this.healt);
                else
                    System.out.println("YOU ROCK!!!");
                break;
            case 4:
                this.healt = this.healt - 10;
                if(!this.isAlive())
                    System.out.println("HP: " + this.healt);
                else
                    System.out.println("YOU ROCK!!!");
                break;
            default:
                break;
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