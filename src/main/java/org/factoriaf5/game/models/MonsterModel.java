package org.factoriaf5.game.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "monsters")
public class MonsterModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_monster")
    private Long id;

    @Column(name = "type_monster")
    private String typeMonster;

    @Column(name = "monster_name")
    private String monsterName;

    @Column(name = "monster_damage")
    private int monsterDamage;

    @Column(name = "monster_health")
    private int monsterHealth;

    @Column(name = "monster_bonus")
    private int bonus;

    private Boolean lifeStealingActive = false;
    private Boolean invisibleActive = false;
    private Integer numSkeletons = 5;

    

    public MonsterModel(String typeMonster, String monsterName, int monsterDamage, int monsterHealth, int bonus) {
        this.typeMonster = typeMonster;
        this.monsterName = monsterName;
        this.monsterDamage = monsterDamage;
        this.monsterHealth = monsterHealth;
        this.bonus = bonus;
    }

    public MonsterModel(){

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public String getMonsterName() {
         return monsterName;
        }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getBonus() {
        return bonus;
     }

    public void setBonus(int bonus) { this.bonus = bonus; }

    public Boolean isLifeStealingActive() { return lifeStealingActive; }
    public void setLifeStealingActive(Boolean active) { this.lifeStealingActive = active; }

    public Boolean isInvisibleActive() { return invisibleActive; }
    public void setInvisibleActive(Boolean active) { this.invisibleActive = active; }

    public Integer getNumSkeletons() { return numSkeletons; }
    public void setNumSkeletons(int numSkeletons) { this.numSkeletons = numSkeletons; }

}
