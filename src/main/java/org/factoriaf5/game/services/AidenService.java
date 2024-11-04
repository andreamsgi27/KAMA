package org.factoriaf5.game.services;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.models.MonsterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AidenService {

    private final Aiden aiden;
    private final MonsterModel monster;  // Se agrega una instancia de MonsterModel

    @Autowired
    public AidenService(Aiden aiden, MonsterModel monster) {  // Constructor con inyección de dependencias
        this.aiden = aiden;
        this.monster = monster;
    }

    // Obtener el objeto Aiden
    public Aiden getAiden() {
        return aiden;
    }

    // Actualizar el objeto Aiden con nuevos detalles
    public Aiden updateAiden(Aiden aidenDetails) {
        aiden.setAidenName(aidenDetails.getAidenName());
        aiden.setAidenDescription(aidenDetails.getAidenDescription());
        aiden.setAidenAbility(aidenDetails.getAidenAbility());
        aiden.setAidenHealth(aidenDetails.getAidenHealth());
        aiden.setAidenDamage(aidenDetails.getAidenDamage());
        return aiden;
    }

    // Recibir daño y aplicar habilidades
    public void receiveDamage(int monsterDamage) {
        aiden.setAidenHealth(aiden.getAidenHealth() - monsterDamage);
    }

    public void powerStrike() {
        aiden.setAidenDamage(aiden.getAidenDamage() + 10);
    }

    public int shield() {
        int currentMonsterDamage = monster.getMonsterDamage();  // Obtener monsterDamage
        int reducedDamage = currentMonsterDamage - 5;
        reducedDamage = Math.max(reducedDamage, 0);            // Evitar valores negativos
        monster.setMonsterDamage(reducedDamage);               // Aplicar el daño reducido
        return reducedDamage;
    }

    // Incrementar vidas
    public void incrementHealth(int bonus) {
        aiden.setAidenHealth(aiden.getAidenHealth() + bonus);
    }

    // Verificar si Aiden está vivo
    public boolean isAidenAlive() {
        return aiden.getAidenHealth() > 0;
    }

    // Mostrar mensaje cuando Aiden muere
    public void aidenDie() {
        if (aiden.getAidenHealth() <= 0) {
            System.out.println("Aiden ha muerto.");
        }
    }
}
