package org.factoriaf5.game.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class MonsterModelTests {

    @Test
    void createMonsterModelWithValidParameters() {

        String type = "Zombie";
        String name = "Morti";
        int health = 100;
        int damage = 500;
        int bonus = 50;

        MonsterModel monster = new MonsterModel("Zombie", "Morti", 500, 100, 50);

        assertEquals(type, monster.getTypeMonster());
        assertEquals(name, monster.getMonsterName());
        assertEquals(health, monster.getMonsterHealth());
        assertEquals(damage, monster.getMonsterDamage());
        assertEquals(bonus, monster.getBonus());
    }

    @Test
    void returnCorrectIdAfterSettingIt() {

        MonsterModel monster = new MonsterModel();
        Long expectedId = 1L;
        
        // Use reflection to set the private id field
        ReflectionTestUtils.setField(monster, "id", expectedId);
        
        assertEquals(expectedId, monster.getId());
    }

    @Test
    public void returnCorrectTypeMonsterAfterSettingIt() {

        MonsterModel monster = new MonsterModel();
        monster.setTypeMonster("Goblin");
        assertEquals("Goblin", monster.getTypeMonster());
    }

    @Test
    void returnCorrectMonsterDamageAfterSettingIt() {

        MonsterModel monster = new MonsterModel();
        int newDamage = 150;
        monster.setMonsterDamage(newDamage);
        assertEquals(newDamage, monster.getMonsterDamage());
    }

    @Test
    void returnCorrectMonsterHealthAfterSettingIt() {

        MonsterModel monster = new MonsterModel();
        int newHealth = 1000;
        monster.setMonsterHealth(newHealth);
        assertEquals(newHealth, monster.getMonsterHealth());
    }

    @Test
    void returnCorrectMonsterNameAfterSettingIt() {

        MonsterModel monster = new MonsterModel();
        String newName = "Alduin";
        monster.setMonsterName(newName);
        assertEquals(newName, monster.getMonsterName());
    }

    @Test
    void returnCorrectBonusAfterSettingIt() {

        MonsterModel monster = new MonsterModel();
        int expectedBonus = 50;
        
        monster.setBonus(expectedBonus);
        
        assertEquals(expectedBonus, monster.getBonus());
    }
    
    @Test
    void handleNullValuesForTypeMonsterAndMonsterName() {

        MonsterModel monster = new MonsterModel(null, null, 200,100,10);
        
        assertNull(monster.getTypeMonster());
        assertNull(monster.getMonsterName());
        assertEquals(100, monster.getMonsterHealth());
        assertEquals(200, monster.getMonsterDamage());
        assertEquals(10, monster.getBonus());
    }

    @Test
    void setBonusToZero() {

        MonsterModel monster = new MonsterModel();
        monster.setBonus(0);
        assertEquals(0, monster.getBonus());
    }
}
