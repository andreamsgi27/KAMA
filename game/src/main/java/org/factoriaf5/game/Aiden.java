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
        //aumentar vidas
        public void incrementHealth(int bonus) {
            setAidenHealth(getAidenHealth() + bonus);
        
        }
        //hacer un boolean para saber si aiden esta vivo o si esta muerto
        public boolean aidenisAlive() {
            return getAidenHealth() > 0;
        }
        //hacer un metodo que imprima cuando aide esta muerto y sacar estadisticas

         public void aidenDie() {
        if (getAidenHealth() <= 0);
            System.out.println("Aiden ha muerto.");
        }
    
        //hacer un llamado para ver las estadisticas de la partida
      
        //public String toString() {
          //  return "Estadísticas de la partida:\n" +  
            //        "Puntuación: " + getPuntuacion() + "\n" +
              //      "Nivel: " + getlevels() + "\n" +
                //    "Contador de eventos: " + getContadorEventos();
     //   }
        
    }
