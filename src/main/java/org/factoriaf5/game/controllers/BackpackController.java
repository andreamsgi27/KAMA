package org.factoriaf5.game.controllers; 

import org.factoriaf5.game.models.Backpack;
import org.factoriaf5.game.models.Items;
import org.factoriaf5.game.services.BackpackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/backpacks")
public class BackpackController {

    @Autowired
    private BackpackService backpackService;

    @PostMapping
    public ResponseEntity<Backpack> createBackpack(@RequestBody Backpack backpack) {
        return ResponseEntity.ok(backpackService.createBackpack(backpack));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Backpack> getBackpack(@PathVariable Long id) {
        Backpack backpack = backpackService.getBackpack(id);
        return backpack != null ? ResponseEntity.ok(backpack) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Backpack> updateBackpack(@PathVariable Long id, @RequestBody Backpack backpack) {
        backpack.setId(id);
        return ResponseEntity.ok(backpackService.updateBackpack(backpack));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBackpack(@PathVariable Long id) {
        backpackService.deleteBackpack(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/addItem")
    public ResponseEntity<Backpack> addItemToBackpack(@PathVariable Long id, @RequestBody Items item, @RequestParam int index) {
        Backpack backpack = backpackService.getBackpack(id);
        if (backpack != null) {
            backpackService.addItemToBackpack(backpack, item, index);
            return ResponseEntity.ok(backpack);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/removeItem")
    public ResponseEntity<Backpack> removeItemFromBackpack(@PathVariable Long id, @RequestParam int index) {
        Backpack backpack = backpackService.getBackpack(id);
        if (backpack != null) {
            backpackService.removeItemFromBackpack(backpack, index);
            return ResponseEntity.ok(backpack);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/updateItem")
    public ResponseEntity<Backpack> updateItemInBackpack(@PathVariable Long id, @RequestBody Items newItem, @RequestParam int index) {
        Backpack backpack = backpackService.getBackpack(id);
        if (backpack != null) {
            backpackService.updateItemInBackpack(backpack, newItem, index);
            return ResponseEntity.ok(backpack);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/getItem")
    public ResponseEntity<Items> getItemFromBackpack(@PathVariable Long id, @RequestParam int index) {
        Backpack backpack = backpackService.getBackpack(id);
        if (backpack != null) {
            return ResponseEntity.ok(backpackService.getItemFromBackpack(backpack, index));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}