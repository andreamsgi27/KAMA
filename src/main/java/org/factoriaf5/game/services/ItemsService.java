package org.factoriaf5.game.services;

import java.util.List;
import java.util.Random;

import org.factoriaf5.game.models.Items;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.ItemsRepository;
import org.factoriaf5.game.repositories.MonsterRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    private final ItemsRepository itemsRepository;
    private final MonsterRepository monsterRepository;
    private final Random random = new Random();

    public ItemsService(ItemsRepository itemsRepository, MonsterRepository monsterRepository) {
        this.itemsRepository = itemsRepository;
        this.monsterRepository = monsterRepository;
    }

    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    public String itemFound() {
        String[] possibleItems = {"Lanza", "Poción", "Ajo", "Gafas", "Silbato"};
        String randomItem = possibleItems[random.nextInt(possibleItems.length)];
        Items foundItem = new Items(randomItem);
        itemsRepository.save(foundItem);
        return "Encontraste " + randomItem;
    }

    public int spear(int aidenDamage) {
        int spearDamage = 10;
        int totalDamage = spearDamage + aidenDamage;
        System.out.println("Usas una lanza con " + spearDamage + " de daño.");
        System.out.println("Infliges " + totalDamage + " de daño.");
        return totalDamage;
    }

    public int potion(int aidenHealth) {
        int potionHeal = 20;
        int totalHealth = aidenHealth + potionHeal;
        System.out.println("Usas una poción con " + potionHeal + " de vida.");
        System.out.println("Ahora tienes " + totalHealth + " puntos de vida.");
        return totalHealth;
    }

    public boolean garlic(Long monsterId) {
        MonsterModel monster = monsterRepository.findById(monsterId).orElse(null);
        if (monster != null && "Vampiro".equals(monster.getTypeMonster())) {
            monster.setLifeStealingActive(false); // Desactiva la habilidad de robo de vida
            monsterRepository.save(monster);
            return true;
        }
        return false; // No era un vampiro o no se encontró el monstruo
    }

    public boolean glasses(Long monsterId) {
        MonsterModel monster = monsterRepository.findById(monsterId).orElse(null);
        if (monster != null && "Fantasma".equals(monster.getTypeMonster())) {
            monster.setInvisibleActive(false); // Desactiva la habilidad de invisibilidad
            monsterRepository.save(monster);
            return true;
        }
        return false; // No era un fantasma o no se encontró el monstruo
    }

    public boolean whistle(Long monsterId) {
        MonsterModel monster = monsterRepository.findById(monsterId).orElse(null);
        if (monster != null && "Esqueleto".equals(monster.getTypeMonster())) {
            monster.setNumSkeletons(1); // Reduce la horda a 1 esqueleto
            monsterRepository.save(monster);
            return true;
        }
        return false; // No era un esqueleto o no se encontró el monstruo
    }
}