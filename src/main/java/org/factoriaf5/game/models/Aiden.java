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
    private String aidenname;
    private String aidendescription;
    private String aidenhabilities;
    private int  aidenHealth;
    private int  aidenDamage;

    public Aiden(Long id, String name) {
        this.id = id;
        this.aidenname = name;
    }

        public Long getId() {
            return id;
        }
    
        public String getItemName() {
            return aidenname;
        }
    
        public void setItemName(String itemName) {
            this.aidenname = itemName;
        }
    
        public String getItemDescription() {
            return aidendescription;
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
}
