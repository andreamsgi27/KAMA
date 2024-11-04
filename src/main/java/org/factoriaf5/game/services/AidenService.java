package org.factoriaf5.game.services;

import java.util.List;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.AidenRepository;
import org.springframework.stereotype.Service;
@Service
public class AidenService{

        //public void recibir daño y habilidades
    public void receiveDamage(int monsterDamage) {
        setAidenHealth(getAidenHealth() - monsterDamage);
    }
    public void powerStrike() {
        setAidenDamage(getAidenDamage() + 10);
    }
    
    public int shield() {
    
        int monsterAttack = MonsterModel.getMonsterAttack();
        int reducedAttack = monsterAttack - 5;
        reducedAttack = reducedAttack > 0 ? reducedAttack : 0;
        MonsterModel.setMonsterAttack(reducedAttack);
        return reducedAttack;
        }
        //aumentar vidas
        public void incrementHealth(int bonus) {
            setAidenHealth(getAidenHealth() + bonus);
        
        }
        //hacer un boolean para saber si aiden esta vivo o si esta muerto
        public boolean aidenisAlive() {
            return getAidenHealth() > 0;
        }
        //hacer un metodo que imprima cuando aide esta muerto y sacar estadisticas

        public void aidenDie() {
        if (getAidenHealth() <= 0);
            System.out.println("Aiden ha muerto.");
            //System.out.println(stat());
        }
        
        //aun no implementado, reservado a futuro:
        /*public String stat() {
            return "Estadísticas de la partida:\n" +  
                    "Puntuación: " + getscore() + "\n" +
                    "Nivel que ha muerto: " + getlevels() + "\n" +
                    "Contador de eventos: " + geteventcont();
        } */
        

        public Aiden getAiden() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getAiden'");
        }
        public Aiden updateAiden(Aiden aidenDetails) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'updateAiden'");
        }
        
    }

