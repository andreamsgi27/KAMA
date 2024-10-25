package org.factoriaf5.game;
import java.util.*;

public class Vampire extends Monster {
    

    public Vampire(int health) {
        super(7, health, "vampiro", 20);
    }

    public void lifeStealing(Aiden heroe){
        Random random = new Random();
        int  damage = random.nextInt(11);
        heroe.receiveDamage(damage);
        monsterHealth += damage;

        System.out.println("el vampiro te ha robado "+ damage +" puntos de vida");
        System.out.println("vida actual: "+heroe.getAidenHealth());
        System.out.println("vida del  vampiro; "+ monsterHealth);

    }

    @Override
    public void MonsterAttack(Aiden heroe) {
        System.out.println("El "+ monsterName +" Ataca a Aiden");
        heroe.receiveDamage(monsterDamage);
    }

    @Override
    public boolean monsterIsAlive() {
        return monsterHealth > 0;
    }

    @Override
    public void monsterDie(Aiden heroe) {
        if(!monsterIsAlive()){
            heroe.incrementHealth(bonus);
            System.out.println("el vampiro ha muerto recibes 20 puntos de vida");
        }
    }

    @Override
    public String toString() {
        return "Vampire []";
    }

}
