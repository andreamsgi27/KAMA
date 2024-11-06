package org.factoriaf5.game.controllers;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.services.AidenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


    @PutMapping
    public ResponseEntity<Aiden> updateAiden(@RequestBody Aiden aidenDetails) {
        Aiden updatedAiden = aidenService.updateAiden(aidenDetails);
        return ResponseEntity.ok(updatedAiden);
    }
    
}


