package org.factoriaf5.game;
import java.util.*;

public class Phantom extends Monster {


    public Phantom( int health) {
        super(7, health, "fantasma", 15);
    }

    public boolean invisible () {
        Random random = new Random();
        int invisible = random.nextInt(1);
        if (invisible == 0) {
            return true;
        }else{
            return false;
        }
    }


    @Override
    public void MonsterAttack(Aiden heroe) {
        System.out.println("El "+ monsterName +" Ataca a Aiden");
        heroe.receiveDamage(monsterDamage);
    }

    @Override
    public void monsterDie() {
        if(!monsterIsAlive()){
            heroe.incrementHealth(bonus);
            System.out.println("el fantasma ha muerto recibes 15 puntos de vida");
        }
    }

    @Override
    public boolean monsterIsAlive() {
        return monsterHealth > 0;
    }

}
