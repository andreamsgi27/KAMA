package org.factoriaf5.game.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monsters")
public class MonsterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_monster")
    private Long id;

    @Enumerated(EnumType.STRING)
    private String typeMonster;

    private int monsterDamage;
    private int monsterHealth;
    private String monsterName;
    private int bonus;

    // Atributos para habilidades especiales
    private boolean lifeStealingActive = false;
    private boolean invisibleActive = false;
    private int numSkeletons = 1; // Número de esqueletos en una horda

    public MonsterModel(String type, int damage, int health, String name, int bonus) {
        this.typeMonster = type;
        this.monsterDamage = damage;
        this.monsterHealth = health;
        this.monsterName = name;
        this.bonus = bonus;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getTypeMonster() { return typeMonster; }
    public void setTypeMonster(String typeMonster) { this.typeMonster = typeMonster; }
    public int getMonsterDamage() { return monsterDamage; }
    public void setMonsterDamage(int monsterDamage) { this.monsterDamage = monsterDamage; }
    public int getMonsterHealth() { return monsterHealth; }
    public void setMonsterHealth(int monsterHealth) { this.monsterHealth = monsterHealth; }
    public String getMonsterName() { return monsterName; }
    public void setMonsterName(String monsterName) { this.monsterName = monsterName; }
    public int getBonus() { return bonus; }
    public void setBonus(int bonus) { this.bonus = bonus; }

    // Métodos booleanos para las habilidades especiales
    public boolean isLifeStealingActive() { return lifeStealingActive; }
    public void setLifeStealingActive(boolean active) { this.lifeStealingActive = active; }

    public boolean isInvisibleActive() { return invisibleActive; }
    public void setInvisibleActive(boolean active) { this.invisibleActive = active; }

    public int getNumSkeletons() { return numSkeletons; }
    public void setNumSkeletons(int numSkeletons) { this.numSkeletons = numSkeletons; }
}
