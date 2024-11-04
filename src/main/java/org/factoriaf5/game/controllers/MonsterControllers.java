package org.factoriaf5.game.controllers;

import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.services.MonsterService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/monsters")
public class MonsterControllers {
    
    private final MonsterService monsterService;
    
    @Autowired
    public MonsterControllers(MonsterService monsterService) {
        this.monsterService = monsterService;
    }
    
    @PostMapping("/post")
    public ResponseEntity<MonsterModel> createMonster(@RequestBody MonsterModel monster) {
        MonsterModel createdMonster = monsterService.createMonster("Esqueleto", "Esqueleto", 10, 100);
        return new ResponseEntity<>(createdMonster, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonsterModel> getMonsterById(@PathVariable Long id) {
        MonsterModel monster = monsterService.getMonsterById(id);
        return ResponseEntity.ok(monster);
    }

    @GetMapping
    public ResponseEntity<List<MonsterModel>> getAllMonsters() {
        List<MonsterModel> monsters = monsterService.getAllMonsters();
        return ResponseEntity.ok(monsters);
    }


}