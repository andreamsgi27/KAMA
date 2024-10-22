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
    
    public int shield() {
    
        int monsterAttack = Monster.getMonsterAttack();
        int reducedAttack = monsterAttack - 5;
        reducedAttack = reducedAttack > 0 ? reducedAttack : 0;
        Monster.setMonsterAttack(reducedAttack);
        return reducedAttack;   
            
            
        }
    }
          
    //Creo que hay que pasar por párametro int monsterattack o de alguna manera ponerlo
    //y luego hacer un set para que se actualice el valor de monsterAttack
    //es de tipo int y retorna un int
    
    /* ejemplo en items:
     * public int Spear (int aidenDamage) {
        itemName = "Lanza";
        int swordDamage = 10;
        int totalDamage  = swordDamage + aidenDamage;
        System.out.println("Aiden usa una lanza con" + swordDamage + " de daño.");
        System.out.println("Aiden inflige" + totalDamage + " de daño");
        return totalDamage;
    }
     */
    


