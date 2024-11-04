package org.factoriaf5.game.services;

import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.MonsterRepository;
import java.util.Random;

public class MonsterService {

    MonsterRepository repository;

    public MonsterService (MonsterRepository repository){
        this.repository = repository;
    }

    public void MonsterAttack(MonsterModel monster, Aiden heroe) {
        Long baseDamage  = monster.getMonsterDamage();
        Long totalDamage = habilityMonster(monster, baseDamage);
        heroe.receiveDamage(totalDamage);
        System.out.println("El "+ monster.getMonsterName() +" Ataca a Aiden");
    }

    public Long habilityMonster(MonsterModel monster, Long baseDamage){
        switch(monster.getTypeMonster()){
            case "Esqueleto":
                 return horda(monster, baseDamage);   
            case "Fantasma":
                return invisible(monster, baseDamage);
            case "Vampiro":
                return lifeStealing(monster, baseDamage);
        }
    }

    public Long horda(MonsterModel monster, Long baseDamage/*llamo a la clase correspondiente de items */){
        /*if(metodo para comprobar si se usa un objeto){
         * syso("usas un objeto que anula las habilidades del monstruo");
         * return monster.getMonsterDamage();
        } */
        Random random = new Random();
        int numSkeletons = random.nextInt(3) + 1;
        int totalDamage = baseDamage * numSkeletons;
        System.out.println("Ha paparecido un horda de esqueletos!"+ numSkeletons +" esqueletos atacan");
        return totalDamage;
    }


    public Long lifeStealing(MonsterModel monster, Long baseDamage/*llamo a la clase correspondiente de items */){
        /*if(metodo para comprobar si se usa un objeto){
         * syso("usas un objeto que anula las habilidades del monstruo");
         * return monster.getMonsterDamage();
        } */
        int stolenLife = baseDamage / 2;
        monster.setMonsterHealth(monster.getMonsterHealth() + stolenLife);
        System.out.println("El vampiro te ha robado "+ stolenLife +" de tu vida! ");
        return baseDamage + stolenLife; 
    }
}
