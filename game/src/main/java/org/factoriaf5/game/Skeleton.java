package org.factoriaf5.game;
import java.util.*;

public class Skeleton extends Monster {

    public Skeleton(int damage, int health){
        super(damage, health,"esqueleto", 5);
    }

    @Override
    public void MonsterAttack(Aiden heroe) {
        System.out.println("El "+ monsterName +" Ataca a Aiden");
        heroe.receiveDamage(monsterDamage);
    }

    public int numSkeletons(boolean horda){
        Random random = new Random();
        if(!horda){
            System.out.println("un objeto ha anulado la horda de esqueletos");
            return monsterDamage;
        }else{
            int numeroEsqueletos = random.nextInt(4) + 1;
            int totalDamage = monsterDamage * numeroEsqueletos;
            super.setMonsterDamage(totalDamage);
            System.out.println("una horda de "+ numeroEsqueletos +" Esqueletos ha aparecido ");
            return totalDamage;
        }

    }

    @Override
    public boolean isAlive() {
        return monsterHealth > 0;
    }

    @Override
    public void monsterDie(Aiden heroe) {
        if(!isAlive()){
            heroe.incrementHealth(bonus);
            System.out.println("el esqueleto ha muerto aiden recibe 5 puntos de vida");
        }
       
    }
    
}
