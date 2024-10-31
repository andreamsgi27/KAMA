package org.factoriaf5.game.models;

import jakarta.persistence.*;
import lombok.*;

    @Data
    @Entity
    @Table(name = "monsters")

public class MonsterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_monster") 

    private Long id;
    private Long monsterDamage;
    private Long monsterHealth;
    private String monsterName;
    private int bonus;

}

public Monster(Long id, Long monsterDamage, Long monsterHealth,  String monsterName, int bonus) {

    this.id= id;
    this.monsterDamage= monsterDamage;
    this.monsterHealth= monsterHealth;
    this.monsterName= monsterName;
    this.bonus= bonus;

}





