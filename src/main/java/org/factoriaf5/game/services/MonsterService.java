package org.factoriaf5.game.services;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.MonsterRepository;

import java.util.Random;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;

public class MonsterService {

    MonsterRepository repository;

    public MonsterService (MonsterRepository repository){
        this.repository = repository;
    }

    public void MonsterAttack(MonsterModel monster, Aiden heroe) {
        int baseDamage  = monster.getMonsterDamage();
        int totalDamage = habilityMonster(monster, baseDamage);
        heroe.receiveDamage(totalDamage);
        System.out.println("El "+ MonsterModel.getMonsterName() +" Ataca a Aiden");
    }

    public int habilityMonster(MonsterModel monster, int baseDamage){
        switch(monster.getTypeMonster()){
            case "Esqueleto":
                return horda(monster, baseDamage);
            case "Fantasma":
                return invisible(monster, baseDamage);
            case "Vampiro":
                return lifeStealing(monster, baseDamage);
        }
                return baseDamage;
    }

    public int  horda(MonsterModel monster, int baseDamage/*llamo a la clase correspondiente de items */){
        /*if(metodo para comprobar si se usa un objeto){
         * syso("usas un objeto que anula las habilidades del monstruo");
         * return monster.getMonsterDamage();
        } */
        Random random = new Random();
        int numSkeletons = random.nextInt(3) + 1;
        int totalDamage = baseDamage * numSkeletons;
        System.out.println("Ha paparecido un horda de esqueletos!"+ numSkeletons +" esqueletos atacan");
        return totalDamage;
    }


    public int lifeStealing(MonsterModel monster, int baseDamage/*llamo a la clase correspondiente de items */){
        /*if(metodo para comprobar si se usa un objeto){
         * syso("usas un objeto que anula las habilidades del monstruo");
         * return monster.getMonsterDamage();
        } */
        int stolenLife = baseDamage / 2;
        monster.setMonsterHealth(monster.getMonsterHealth() + stolenLife);
        System.out.println("El vampiro te ha robado "+ stolenLife +" de tu vida! ");
        return baseDamage + stolenLife;
    }

    public int invisible(MonsterModel monster, int baseDamage/*llamo a la clase correspondiente de items */){
    /*if(metodo para comprobar si se usa un objeto){
         * syso("usas un objeto que anula las habilidades del monstruo");
         * return monster.getMonsterDamage();
        } */
    Random random = new Random();
        if (random.nextBoolean()) {
            System.out.println("El Fantasma se vuelve invisible y evade el ataque de Aiden");
            return 0;
        } else {
            System.out.println("El Fantasma ataca desde las sombras");
            return (int) (baseDamage * 1.5);
        }
    }

    public MonsterModel createMonster(String type, String name, int damage, int health) {
        MonsterModel monster = new MonsterModel(name, damage, health, type, 0); 
        return repository.save(monster);
    }
    
    public MonsterModel getMonsterById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Monstruo no encontrado con id: " + id));
    }

    public List<MonsterModel> getAllMonsters() {
        return repository.findAll();
    }
    
    public MonsterModel updateMonster(Long id, MonsterModel updatedMonster) {
        MonsterModel monster = getMonsterById(id);
        monster.setMonsterName(updatedMonster.getMonsterName());
        monster.setMonsterDamage(updatedMonster.getMonsterDamage());
        monster.setTypeMonster(updatedMonster.getTypeMonster());
        // Actualiza otros campos según sea necesario
        return repository.save(monster);
    }

    public List<MonsterModel> getMonstersByType(String type) {
        return repository.findByTypeMonster(type);
    }

    public boolean isMonsterAlive(MonsterModel monster) {
        return monster.getMonsterHealth() > 0;
    }

    public void monsterReceiveDamage(MonsterModel monster, int damage) {
        int currentHealth = monster.getMonsterHealth();
        int newHealth = Math.max(0, currentHealth - damage);
        monster.setMonsterHealth(newHealth);
        repository.save(monster);
    }

    public void deleteMonster(Long id) {
        repository.deleteById(id);
    }
    public int monsterAttack(Long id) {
        MonsterModel monster = getMonsterById(id);
        return monster.getMonsterDamage();
    }

    public MonsterModel monsterReceiveDamage(Long id, int damage) {
        MonsterModel monster = getMonsterById(id);
        int newHealth = Math.max(0, monster.getMonsterHealth() - damage);
        monster.setMonsterHealth(newHealth);
        return repository.save(monster);
    }

    public boolean isMonsterAlive(Long id) {
        MonsterModel monster = getMonsterById(id);
        return monster.getMonsterHealth() > 0;
    }


}
