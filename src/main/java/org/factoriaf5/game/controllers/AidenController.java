package org.factoriaf5.game.controllers;

import java.util.List;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.services.AidenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AidenController {
    private final AidenService AidenService;

    public AidenController(AidenService itemsService) {
        this.AidenService = itemsService;
    }
    
}
