package org.factoriaf5.game;
import java.util.*;

public class Skeleton extends Monster {

    public Skeleton(int damage, int health){
        super(damage, health,"esqueleto");
    }

    @Override
    public void MonsterAtack(Aiden heroe) {
        System.out.println("El "+ monsterName +" Ataca a Aiden");
        heroe.receiveDamage(monsterDamage);
        throw new UnsupportedOperationException("Unimplemented method 'MonsterAtack'");
    }

    public int numSkeletons(boolean horda){
        Random random = new Random();
        if(!horda){
            System.out.println("un objeto ha anulado la horda de esqueletos");
            return monsterDamage;
        }else{
            int numeroEsqueletos = random.nextInt(4) + 1;
            int totalDamage = monsterDamage * numeroEsqueletos;
            System.out.println("una horda de "+ numeroEsqueletos +" Esqueletos ha aparecido ");
            return totalDamage;
        }

    }
    
}
