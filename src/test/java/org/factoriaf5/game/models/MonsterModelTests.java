package org.factoriaf5.game.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

//@SpringBootTest == si agregamos  esto, el test se ejecuta en un contexto de Spring Boot, lo cual da fallos por todas partes

class MonsterModelTests {

    @Test
    void createMonsterModelWithValidParameters() {

        String type = "Zombie";
        int damage = 100;
        int health = 500;
        String name = "Morti";
        int bonus = 50;

        MonsterModel monster = new MonsterModel(type, damage, health, name, bonus);

        assertEquals(type, monster.getTypeMonster());
        assertEquals(damage, monster.getMonsterDamage());
        assertEquals(health, monster.getMonsterHealth());
        assertEquals(name, monster.getMonsterName());
        assertEquals(bonus, monster.getBonus());
    }

    @Test
    void returnCorrectIdAfterSettingIt() {

        MonsterModel monster = new MonsterModel("Zombie", 100, 1000, "Morti", 10);
        Long expectedId = 1L;
        
        // Use reflection to set the private id field
        ReflectionTestUtils.setField(monster, "id", expectedId);
        
        assertEquals(expectedId, monster.getId());
    }

    @Test
    public void returnCorrectTypeMonsterAfterSettingIt() {

        MonsterModel monster = new MonsterModel("Zombie", 100, 200, "Morti", 10);
        monster.setTypeMonster("Goblin");
        assertEquals("Goblin", monster.getTypeMonster());
    }

    @Test
    void returnCorrectMonsterDamageAfterSettingIt() {

        MonsterModel monster = new MonsterModel("Zombie", 100, 1000, "Morti", 50);
        int newDamage = 150;
        monster.setMonsterDamage(newDamage);
        assertEquals(newDamage, monster.getMonsterDamage());
    }

    @Test
    void returnCorrectMonsterHealthAfterSettingIt() {

        MonsterModel monster = new MonsterModel("Zombie", 100, 500, "Morti", 50);
        int newHealth = 1000;
        monster.setMonsterHealth(newHealth);
        assertEquals(newHealth, monster.getMonsterHealth());
    }

    @Test
    void returnCorrectMonsterNameAfterSettingIt() {

        MonsterModel monster = new MonsterModel("Zombie", 100, 1000, "Morti", 10);
        String newName = "Alduin";
        monster.setMonsterName(newName);
        assertEquals(newName, monster.getMonsterName());
    }

    @Test
    void returnCorrectBonusAfterSettingIt() {

        MonsterModel monster = new MonsterModel("Zombie", 100, 1000, "Morti", 0);
        int expectedBonus = 50;
        
        monster.setBonus(expectedBonus);
        
        assertEquals(expectedBonus, monster.getBonus());
    }

    @Test
    void handleNegativeValuesForDamageAndHealth() {

        MonsterModel monster = new MonsterModel("Zombie", 100, 200, "Morti", 10);
        
        monster.setMonsterDamage(-50);
        monster.setMonsterHealth(-100);
        
        assertEquals(-50, monster.getMonsterDamage());
        assertEquals(-100, monster.getMonsterHealth());
    }

    @Test
    void handleNullValuesForTypeMonsterAndMonsterName() {

        MonsterModel monster = new MonsterModel(null, 100, 200, null, 10);
        
        assertNull(monster.getTypeMonster());
        assertNull(monster.getMonsterName());
        assertEquals(100, monster.getMonsterDamage());
        assertEquals(200, monster.getMonsterHealth());
        assertEquals(10, monster.getBonus());
    }

    @Test
    void setBonusToZero() {

        MonsterModel monster = new MonsterModel("Zombie", 100, 200, "Morti", 10);
        monster.setBonus(0);
        assertEquals(0, monster.getBonus());
    }
}
