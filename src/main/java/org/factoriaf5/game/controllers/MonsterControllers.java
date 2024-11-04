package org.factoriaf5.game.controllers;


import java.util.List;

import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.services.MonsterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monsters")
public class MonsterControllers {
    
    private final MonsterService monsterService;
    
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

    @PutMapping("/{id}")
    public ResponseEntity<MonsterModel> updateMonster(@PathVariable Long id, @RequestBody MonsterModel monster) {
        MonsterModel updatedMonster = monsterService.updateMonster(id, monster);
        return ResponseEntity.ok(updatedMonster);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonster(@PathVariable Long id) {
        monsterService.deleteMonster(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/attack")
    public ResponseEntity<Integer> monsterAttack(@PathVariable Long id) {
        int damage = monsterService.monsterAttack(id);
        return ResponseEntity.ok(damage);
    }

    @PostMapping("/{id}/receive-damage")
    public ResponseEntity<MonsterModel> monsterReceiveDamage(@PathVariable Long id, @RequestParam int damage) {
        MonsterModel updatedMonster = monsterService.monsterReceiveDamage(id, damage);
        return ResponseEntity.ok(updatedMonster);
    }

    @GetMapping("/{id}/is-alive")
    public ResponseEntity<Boolean> isMonsterAlive(@PathVariable Long id) {
        boolean isAlive = monsterService.isMonsterAlive(id);
        return ResponseEntity.ok(isAlive);
    }


}