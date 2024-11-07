package org.factoriaf5.game.controllers;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.services.AidenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/aiden")
public class AidenController {

    @Autowired
   private AidenService aidenService;


    @GetMapping
    public ResponseEntity<Aiden> getAiden() {
        Aiden aiden = aidenService.getAiden();
        return ResponseEntity.ok(aiden);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAiden() {
        aidenService.deleteAiden(); // Llamamos al servicio para eliminar a Aiden
        return ResponseEntity.ok("Aiden eliminado exitosamente.");
    }
//    @PostMapping
//public ResponseEntity<Aiden> createAiden(@RequestBody Aiden newAiden) {
  //  Aiden createdAiden = aidenService.createAiden(newAiden); // Cambiar a create si es un create, no update
    //return ResponseEntity.status(201).body(createdAiden);
//}

//@PutMapping
//public ResponseEntity<Aiden> updateAiden(@RequestBody Aiden updatedAiden) {
  //  Aiden updated = aidenService.updateAiden(updatedAiden); // Asegúrate de que este método retorne el Aiden actualizado
    //return ResponseEntity.ok(updated); 
//}
 @PutMapping("/update-damage/{id}")
    public ResponseEntity<Aiden> updateDamage(@PathVariable Long id, @RequestBody int newDamage) {
        Aiden updatedAiden = aidenService.updateDamage(id, newDamage);
        return ResponseEntity.ok(updatedAiden);
    }

    // Endpoint para actualizar la salud de Aiden
    @PutMapping("/update-health/{id}")
    public ResponseEntity<Aiden> updateHealth(@PathVariable Long id, @RequestBody int newHealth) {
        Aiden updatedAiden = aidenService.updateHealth(id, newHealth);
        return ResponseEntity.ok(updatedAiden);
    }

}