package org.factoriaf5.game;

import static org.junit.jupiter.api.Assertions.*;

import org.factoriaf5.game.models.MonsterModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
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
    assertEquals(Long.valueOf(damage), monster.getMonsterDamage());
    assertEquals(Long.valueOf(health), monster.getMonsterHealth());
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
    Long newDamage = 150L;
    monster.setMonsterDamage(newDamage);
    assertEquals(newDamage, monster.getMonsterDamage());

}

@Test
void returnCorrectMonsterHealthAfterSettingIt() {

    MonsterModel monster = new MonsterModel("Zombie", 100, 500, "Morti", 50);
    Long newHealth = 1000L;
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
    
    monster.setMonsterDamage(-50L);
    monster.setMonsterHealth(-100L);
    
    assertEquals(0L, monster.getMonsterDamage());
    assertEquals(0L, monster.getMonsterHealth());

}

@Test
void handleNullValuesForTypeMonsterAndMonsterName() {

    MonsterModel monster = new MonsterModel(null, 100, 200, null, 10);
    
    assertNull(monster.getTypeMonster());
    assertNull(monster.getMonsterName());
    assertEquals(100L, monster.getMonsterDamage());
    assertEquals(200L, monster.getMonsterHealth());
    assertEquals(10, monster.getBonus());

}

@Test
void setBonusToZero() {

    MonsterModel monster = new MonsterModel("Zombie", 100, 200, "Morti", 10);
    monster.setBonus(0);
    assertEquals(0, monster.getBonus());

}

}