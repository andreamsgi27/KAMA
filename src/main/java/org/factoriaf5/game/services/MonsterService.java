package org.factoriaf5.game.services;

import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.MonsterRepository;

public class MonsterService {

    MonsterRepository repository;

    public MonsterService (MonsterRepository repository){
        this.repository = repository;
    }

    public void MonsterAttack(MonsterModel monster, Aiden heroe) {
        long baseDamage  = monster.getMonsterDamage();
        Long totalDamage = habilityMonster(monster, baseDamage);
        System.out.println("El "+ monster.getMonsterName +" Ataca a Aiden");
        heroe.receiveDamage(monsterDamage);
    }

    public void habilityMonster(MonsterModel monster, int baseDamage){
        switch(monster.getTypeMonster){
            case "Esqueleto":
                 return horda(MonsterModel monster, int baseDamage);
                 break;   
            case "Fantasma":
                return invisible(MonsterModel monster, int baseDamage);
                break;
            case "Vampiro":
                return lifeStealing(MonsterModel monster, int baseDamage);
        }
    }


}
