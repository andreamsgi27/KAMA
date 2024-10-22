package org.factoriaf5.game;

public class Skeleton extends Monster {

    public Skeleton(int damage, int health){
        super(damage, health,"esqueleto");
    }

    @Override
    public void MonsterAttack(Aiden heroe) {
        System.out.println("El "+ monsterName +" Ataca a Aiden");
        heroe.receiveDamage(monsterDamage);
    }

    public void numSkeletons(){
        
    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAlive'");
    }

    @Override
    public void monsterDie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'monsterDie'");
    }
    
}
