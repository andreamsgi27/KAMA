package org.factoriaf5.game;

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

    //public void recibir daño y habilidades
    public void receiveDamage(int monsterDamage) {
        setAidenHealth(getAidenHealth() - monsterDamage);
    }
    public void powerStrike() {
        aidenDamage += 10;
    }
       public  void shield(){
        Monster.monsterAtack()-= 5;
       }
    }



