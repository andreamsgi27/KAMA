package org.factoriaf5.game.services;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.AidenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AidenService {

    private static AidenRepository aidenRepository;

    @Autowired
    public AidenService(AidenRepository aidenRepository) {
        AidenService.aidenRepository = aidenRepository;
    }

    // Obtener el objeto Aiden
    public Aiden getAiden() {
        return aidenRepository.findById(1L)  // Ajusta el ID según el caso
                .orElseThrow(() -> new RuntimeException("Aiden no encontrado"));
    }

    // Actualizar el objeto Aiden con nuevos detalles
    public Aiden updateAiden(Aiden aidenDetails) {
        Aiden aiden = getAiden();
        aiden.setAidenName(aidenDetails.getAidenName());
        aiden.setAidenDescription(aidenDetails.getAidenDescription());
        aiden.setAidenAbility(aidenDetails.getAidenAbility());
        aiden.setAidenHealth(aidenDetails.getAidenHealth());
        aiden.setAidenDamage(aidenDetails.getAidenDamage());
        return aidenRepository.save(aiden);
    }

    // Recibir daño y aplicar habilidades
    public void receiveDamage(int monsterDamage) {
        Aiden aiden = getAiden();
        aiden.setAidenHealth(aiden.getAidenHealth() - monsterDamage);
        aidenRepository.save(aiden);
    }

    public void powerStrike() {
        Aiden aiden = getAiden();
        aiden.setAidenDamage(aiden.getAidenDamage() + 10);
        aidenRepository.save(aiden);
    }

    public int shield(MonsterModel monster) {
        int reducedDamage = monster.getMonsterDamage() - 5;
        reducedDamage = Math.max(reducedDamage, 0);  
        monster.setMonsterDamage(reducedDamage);  
        return reducedDamage;
    }

    public void incrementHealth(int bonus) {
        Aiden aiden = getAiden();
        aiden.setAidenHealth(aiden.getAidenHealth() + bonus);
        aidenRepository.save(aiden);
    }

    public boolean isAidenAlive() {
        return getAiden().getAidenHealth() > 0;
    }

    public void aidenDie() {
        if (!isAidenAlive()) {
            System.out.println("Aiden ha muerto.");
        }
    }
}
