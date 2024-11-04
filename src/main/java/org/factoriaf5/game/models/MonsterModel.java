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
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_monster") 
    private Long id;

    @Enumerated(EnumType.STRING)
    private String typeMonster;
    
    private int monsterDamage;
    private int monsterHealth;
    private static String monsterName;
        private int bonus;
        
        public MonsterModel(String type, int damage, int health, String name, int bonus){
            this.typeMonster = type;
            this.monsterDamage = damage;
            this.monsterHealth = health;
            MonsterModel.monsterName = name;
            this.bonus = bonus;
        }
    
        public Long getId() {
            return id;
        }
    
        public String getTypeMonster() {
            return typeMonster;
        }
    
        public void setTypeMonster(String typeMonster) {
            this.typeMonster = typeMonster;
        }
    
        public int getMonsterDamage() {
            return monsterDamage;
        }
    
        public void setMonsterDamage(int monsterDamage) {
            this.monsterDamage = monsterDamage;
        }
    
        public int getMonsterHealth() {
            return monsterHealth;
        }
    
        public void setMonsterHealth(int monsterHealth) {
            this.monsterHealth = monsterHealth;
        }
    
        public static String getMonsterName() {
            return monsterName;
    }

    public void setMonsterName(String monsterName) {
        MonsterModel.monsterName = monsterName;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}