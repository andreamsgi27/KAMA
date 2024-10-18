package org.factoriaf5.game;

abstract class Monster {
    
    //atributos
    public int monsterDamage;
    public int monsterHealth;
    public String monsterName;

    //constructor 
    public Monster(int damage, int health,String name){
        this.monsterDamage = damage;
        this.monsterHealth =  health;
        this.monsterName = name;
    }

    //getters y setters
    public int getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(int monsterDamage) {
        monsterDamage = monsterDamage;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        monsterHealth = monsterHealth;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
    

    //tostring
    @Override
    public String toString() {
        return "Monster [MonsterDamage=" + monsterDamage + ", MonsterHealth=" + monsterHealth + "]";
    }

    //methods
    public abstract void MonsterAtack(Aiden heroe);

    
   
    
}