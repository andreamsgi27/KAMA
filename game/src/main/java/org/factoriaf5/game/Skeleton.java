package org.factoriaf5.game;

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

    public void numSkeletons(){
        
    }
    
}
