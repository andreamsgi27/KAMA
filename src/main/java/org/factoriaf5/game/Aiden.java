package org.factoriaf5.game;
import java.util.Scanner;
public class Aiden {
    private int aidenHealth;
    private int aidenDamage;
   
public Aiden(){
        this.aidenHealth = 100; 
        this.aidenDamage = 15;
}
    
    // Métodos get y set para aidenHealth
    public int getAidenHealth() {
        return aidenHealth;
    }

    public void setAidenHealth(int aidenHealth) {
        this.aidenHealth = aidenHealth;
    }

    // Métodos get y set para aidenDamage
    public int getAidenDamage() {
        return aidenDamage;
    }

    public void setAidenDamage(int aidenDamage) {
        this.aidenDamage = aidenDamage;
    }

}