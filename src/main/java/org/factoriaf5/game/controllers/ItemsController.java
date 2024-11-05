package org.factoriaf5.game.controllers;

import org.factoriaf5.game.services.ItemsService;
import org.factoriaf5.game.services.MonsterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemsController {

    private final ItemsService itemsService;
    private final MonsterService monsterService;

    public ItemsController(ItemsService itemsService, MonsterService monsterService) {
        this.itemsService = itemsService;
        this.monsterService = monsterService;
    }

    // Endpoint para obtener un ítem aleatorio
    @GetMapping("/found")
    public String itemFound() {
        return itemsService.itemFound();
    }

    // Endpoint para usar una lanza contra un monstruo
    @PostMapping("/spear")
    public int useSpear(@RequestParam int aidenDamage) {
        return itemsService.spear(aidenDamage);
    }

    // Endpoint para usar una poción y curar a Aiden
    @PostMapping("/potion")
    public int usePotion(@RequestParam int aidenHealth) {
        return itemsService.potion(aidenHealth);
    }

    // Endpoint para usar ajo contra un vampiro
    @PostMapping("/garlic")
    public String useGarlic(@RequestParam Long monsterId) {
        boolean success = itemsService.garlic(monsterId);
        return success ? "El ajo desactiva la habilidad de robo de vida del vampiro." : "No se pudo aplicar el ajo.";
    }

    // Endpoint para usar gafas contra un fantasma
    @PostMapping("/glasses")
    public String useGlasses(@RequestParam Long monsterId) {
        boolean success = itemsService.glasses(monsterId);
        return success ? "Las gafas desactivan la invisibilidad del fantasma." : "No se pudo aplicar las gafas.";
    }

    // Endpoint para usar el silbato contra una horda de esqueletos
    @PostMapping("/whistle")
    public String useWhistle(@RequestParam Long monsterId) {
        boolean success = itemsService.whistle(monsterId);
        return success ? "El silbato dispersa la horda de esqueletos." : "No se pudo usar el silbato.";
    }
}