import org.factoriaf5.game.services.ItemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
    private final ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    // Endpoint para obtener un ítem aleatorio
    @GetMapping("/items/found")
    public String itemFound() {
        return itemsService.itemFound();
    }

    // Endpoint para usar una lanza
    @PostMapping("/items/spear")
    public int useSpear(@RequestParam int aidenDamage) {
        return itemsService.spear(aidenDamage);
    }

    // Endpoint para usar una poción
    @PostMapping("/items/potion")
    public int usePotion(@RequestParam int aidenHealth) {
        return itemsService.potion(aidenHealth);
    }

    // Endpoint para usar ajo
    @PostMapping("/items/garlic")
    public String useGarlic() {
        return itemsService.garlic();
    }

    // Endpoint para usar gafas
    @PostMapping("/items/glasses")
    public String useGlasses() {
        return itemsService.glasses();
    }

    // Endpoint para usar el silbato
    @PostMapping("/items/whistle")
    public String useWhistle() {
        return itemsService.whistle();
    }
}