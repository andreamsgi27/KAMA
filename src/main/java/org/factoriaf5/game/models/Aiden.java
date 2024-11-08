package org.factoriaf5.game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Aiden")
public class Aiden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aidenName;
    private String aidenDescription;
    private String aidenAbility;
    private int aidenHealth;
    private int aidenDamage;

    public Aiden() {
        this.aidenHealth = 100;
        this.aidenDamage = 15;
    }

    public Aiden(Long id, String aidenName, String aidenDescription, String aidenAbility) {
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

    public String getAidenName() {
        return aidenName;
    }

    public void setAidenName(String aidenName) {
        this.aidenName = aidenName;
    }

    public String getAidenDescription() {
        return aidenDescription;
    }

    public void setAidenDescription(String aidenDescription) {
        this.aidenDescription = aidenDescription;
    }

    public String getAidenAbility() {
        return aidenAbility;
    }

    public void setAidenAbility(String aidenAbility) {
        this.aidenAbility = aidenAbility;
    }

    public int getAidenHealth() {
        return aidenHealth;
    }

    public void setAidenHealth(int aidenHealth) {
        this.aidenHealth = aidenHealth;
    }

    public int getAidenDamage() {
        return aidenDamage;
    }

    public void setAidenDamage(int aidenDamage) {
        this.aidenDamage = aidenDamage;
    }

    public void receiveDamage(int totalDamage) {
        setAidenHealth(getAidenHealth() - totalDamage);
    }
}