/* package org.factoriaf5.game.services;

import org.factoriaf5.game.Items;
import org.factoriaf5.game.repositories.ItemsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class ItemsService {
    private final ItemsRepository repository;
    private final Random random = new Random();

    public ItemsService(ItemsRepository repository) {
        this.repository = repository;
    }

    public List<Items> getAllItems() {
        return repository.findAll();
    }

    public String itemFound() {
        String[] possibleItems = {"Lanza", "Poción", "Ajo", "Gafas", "Silbato"};
        String randomItem = possibleItems[random.nextInt(possibleItems.length)];
        Items foundItem = new Items(randomItem);
        repository.save(foundItem);
        return "Encontraste " + randomItem;
    }

    public int spear(int aidenDamage) {
        int swordDamage = 10;
        int totalDamage = swordDamage + aidenDamage;
        System.out.println("Usas una lanza con " + swordDamage + " de daño.");
        System.out.println("Infliges " + totalDamage + " de daño.");
        return totalDamage;
    }

    public int potion(int aidenHealth) {
        int potion = 20;
        int totalHealth = aidenHealth + potion;
        System.out.println("Usas una poción con " + potion + " de vida.");
        System.out.println("Ahora tienes " + totalHealth + " puntos de vida.");
        return totalHealth;
    }

    public String garlic() {
        // Lógica para interactuar con el vampiro
        // Suponiendo que Vampire es una entidad que tienes en el sistema
        if (MonsterModel.getMonsterName().equalsIgnoreCase("Vampiro") && MonsterModel.getLifeStealing()) {
            MonsterModel.setLifeStealing(false);
            return "El vampiro ya no puede robarte vida.";
        } else {
            return "El ajo no puede usarse en este momento.";
        }
    }

    public String glasses() {
        // Lógica para interactuar con el fantasma
        if (MonsterModel.getMonsterName().equalsIgnoreCase("Fantasma") && MonsterModel.getInvisibility()) {
            MonsterModel.setInvisibility(false);
            return "El fantasma ya no es invisible.";
        } else {
            return "Las gafas no pueden usarse en este momento.";
        }
    }

    public String whistle() {
        // Lógica para interactuar con el esqueleto
        if (MonsterModel.getMonsterName().equalsIgnoreCase("Esqueleto") && MonsterModel.getNumSkeletons() >= 2) {
            MonsterModel.setNumSkeletons(1);
            return "Usas el silbato, y aparece un lobo enorme que se come a todos los esqueletos dejando solo a uno en pie.";
        } else {
            return "El silbato no puede usarse en este momento.";
        }
    }
}

 */