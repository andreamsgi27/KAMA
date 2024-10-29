package org.factoriaf5.game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Aiden");
public class Aiden {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String habilities;
    private int  aidenHealth;
    private int  aidenDamage;

    public Aiden(Long id, String name) {
        this.id = id;
        this.name = name;

    }
   
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
        System.out.println(stat());
     }
    
    public String stat() {
        return "Estadísticas de la partida:\n" +  
                "Puntuación: " + getscore() + "\n" +
                "Nivel que ha muerto: " + getlevels() + "\n" +
                "Contador de eventos: " + geteventcont();
  }
    
}


