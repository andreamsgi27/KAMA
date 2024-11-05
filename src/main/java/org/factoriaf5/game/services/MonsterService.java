package org.factoriaf5.game.services;

import java.util.List;
import java.util.Random;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.MonsterRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MonsterService {

    private final MonsterRepository repository;

    public MonsterService(MonsterRepository repository) {
        this.repository = repository;
    }

    public void monsterAttack(MonsterModel monster, Aiden heroe) {
        int baseDamage  = monster.getMonsterDamage();
        int totalDamage = applyMonsterAbility(monster, baseDamage);
        heroe.receiveDamage(totalDamage);
        System.out.println("El " + monster.getMonsterName() + " ataca a Aiden");
    }

    // Método que aplica las habilidades especiales del monstruo
    public int applyMonsterAbility(MonsterModel monster, int baseDamage) {
        switch(monster.getTypeMonster()) {
            case "Esqueleto" -> {
                return horda(monster, baseDamage);
            }
            case "Fantasma" -> {
                return invisible(monster, baseDamage);
            }
            case "Vampiro" -> {
                return lifeStealing(monster, baseDamage);
            }
        }
        return baseDamage;
    }

    // Habilidad especial "Horda" para Esqueleto
    public int horda(MonsterModel monster, int baseDamage) {
        if (monster.isInvisibleActive()) {
            Random random = new Random();
            int numSkeletons = random.nextInt(3) + 1;
            monster.setNumSkeletons(numSkeletons);
            int totalDamage = baseDamage * numSkeletons;
            System.out.println("¡Ha aparecido una horda de esqueletos! " + numSkeletons + " esqueletos atacan.");
            return totalDamage;
        } else {
            System.out.println("Usaste un ítem que desactiva la habilidad de horda.");
            return monster.getMonsterDamage();
        }
    }

    // Habilidad especial "Robo de vida" para Vampiro
    public int lifeStealing(MonsterModel monster, int baseDamage) {
        if (monster.isLifeStealingActive()) {
            int stolenLife = baseDamage / 2;
            monster.setMonsterHealth(monster.getMonsterHealth() + stolenLife);
            System.out.println("El vampiro te ha robado " + stolenLife + " de vida.");
            return baseDamage + stolenLife;
        } else {
            System.out.println("Usaste un ítem que desactiva la habilidad de robo de vida.");
            return baseDamage;
        }
    }

    // Habilidad especial "Invisibilidad" para Fantasma
    public int invisible(MonsterModel monster, int baseDamage) {
        if (monster.isInvisibleActive()) {
            Random random = new Random();
            if (random.nextBoolean()) {
                System.out.println("El Fantasma se vuelve invisible y evade el ataque de Aiden.");
                return 0;
            } else {
                System.out.println("El Fantasma ataca desde las sombras.");
                return (int) (baseDamage * 1.5);
            }
        } else {
            System.out.println("Usaste un ítem que desactiva la invisibilidad del fantasma.");
            return baseDamage;
        }
    }

    // Método para crear un nuevo monstruo en la base de datos
    public MonsterModel createMonster(String type, String name, int damage, int health) {
        MonsterModel monster = new MonsterModel(name, damage, health, type, 0); 
        return repository.save(monster);
    }

    // Método para obtener un monstruo por su ID
    public MonsterModel getMonsterById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Monstruo no encontrado con id: " + id));
    }

    // Método para obtener todos los monstruos
    public List<MonsterModel> getAllMonsters() {
        return repository.findAll();
    }
    
    // Método para actualizar un monstruo existente
    public MonsterModel updateMonster(Long id, MonsterModel updatedMonster) {
        MonsterModel monster = getMonsterById(id);
        monster.setMonsterName(updatedMonster.getMonsterName());
        monster.setMonsterDamage(updatedMonster.getMonsterDamage());
        monster.setTypeMonster(updatedMonster.getTypeMonster());
        // Actualiza otros campos según sea necesario
        return repository.save(monster);
    }

    // Método para obtener monstruos por tipo
    public List<MonsterModel> getMonstersByType(String type) {
        return repository.findByTypeMonster(type);
    }

    // Método para verificar si un monstruo está vivo
    public boolean isMonsterAlive(MonsterModel monster) {
        return monster.getMonsterHealth() > 0;
    }

    // Método para aplicar daño al monstruo
    public void monsterReceiveDamage(MonsterModel monster, int damage) {
        int currentHealth = monster.getMonsterHealth();
        int newHealth = Math.max(0, currentHealth - damage);
        monster.setMonsterHealth(newHealth);
        repository.save(monster);
    }

    // Método para eliminar un monstruo
    public void deleteMonster(Long id) {
        repository.deleteById(id);
    }

    // Método auxiliar para realizar un ataque del monstruo
    public int monsterAttack(Long id) {
        MonsterModel monster = getMonsterById(id);
        return monster.getMonsterDamage();
    }

    // Método auxiliar para recibir daño por ID de monstruo
    public MonsterModel monsterReceiveDamage(Long id, int damage) {
        MonsterModel monster = getMonsterById(id);
        int newHealth = Math.max(0, monster.getMonsterHealth() - damage);
        monster.setMonsterHealth(newHealth);
        return repository.save(monster);
    }

    // Verifica si el monstruo sigue vivo a partir de su ID
    public boolean isMonsterAlive(Long id) {
        MonsterModel monster = getMonsterById(id);
        return monster.getMonsterHealth() > 0;
    }
}
