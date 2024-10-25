package org.factoriaf5.game;

public class Phantom extends Monster {


    public Phantom(int damage, int health, String name, int bonus) {
        super(7, health, "fantasma", 15);
        //TODO Auto-generated constructor stub
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
            System.out.println("el vampiro ha muerto recibes 20 puntos de vida");
        }
    }

    @Override
    public boolean monsterIsAlive() {
        return monsterHealth > 0;
    }

}
