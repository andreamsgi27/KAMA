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
    private String aidenName;
    private String aidenDescription;
    private String aidenAbility;
    private int aidenHealth;
    private int aidenDamage;

    public Aiden(Long id, String aidenName, String aidenDescription, String aidenAbility, Long aidenHealth, Long aidenDamage) {
        this.id = id;
        this.aidenName = aidenName;
        this.aidenDescription = aidenDescription;
        this.aidenAbility = aidenAbility;
        this.aidenHealth = 100; 
        this.aidenDamage = 15;

    }

        public Long getId() {
            return id;
        }
    
        public String getaidenName() {
            return aidenName;
        }
    
        public void setaidenName(String aidenName) {
            this.aidenName = aidenName;
        }
    
        public String getaidenDescription() {
            return aidenDescription;
        }
  
        public void setaidenDescription(String aidenDescription) {
            this.aidenDescription = aidenDescription;
        }
        public String getaidenAbility() {
            return aidenAbility;
        }
  
        public void setaidenAbility(String aidenAbility) {
            this.aidenAbility = aidenAbility;
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
