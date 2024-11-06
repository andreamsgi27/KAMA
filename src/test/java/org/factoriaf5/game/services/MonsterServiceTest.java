package org.factoriaf5.game.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.MonsterRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class MonsterServiceTest {
    
    @InjectMocks
    MonsterService service;
    
    
    @Mock
    MonsterRepository repository;
    
    
    @BeforeEach
    void setUp() {
        this.service = new MonsterService(repository);
    }
    
    
    @Test
    void testMonsterAttackWithHeroHaving0Health() {
        
        MonsterModel monster = new MonsterModel("Vampiro", "Vampiro", 20, 60, 20);
        AidenService heroe = mock(AidenService.class);
        Aiden model = mock(Aiden.class);
        when(model.getAidenHealth()).thenReturn(0);

        service.monsterAttack(monster, heroe);

        assertThat(monster.getMonsterHealth(), is(60));
        assertThat(model.getAidenHealth(), is(0));
    }


    @Test
    void testMonsterAttackWithNegativeHeroHealth() {
        // Arrange
        MonsterModel monster = new MonsterModel("Vampiro", "Vampiro", 20, 60, 20);
        AidenService heroe = mock(AidenService.class);
        Aiden model = mock(Aiden.class);
        service.monsterAttack(monster, heroe);
    
        assertThat(monster.getMonsterHealth(), is(60));
    }


    @Test
    void testApplyMonsterAbilityWithSkeletonMonster() {
        
        MonsterModel skeletonMonster = new MonsterModel("Esqueleto", "Esqueleto", 10, 50, 10);
        int baseDamage = 10;
        MonsterService monsterService = new MonsterService(repository);

        int totalDamage = monsterService.applyMonsterAbility(skeletonMonster, baseDamage);

        assertThat(totalDamage, is(equalTo(monsterService.horda(skeletonMonster, baseDamage))));
      }


      @Test
      void testApplyMonsterAbilityWithFantasma() {
        
        MonsterModel monster = new MonsterModel("Fantasma", "Fantasma",20, 60,  15);
        AidenService heroe = mock(AidenService.class);
        int baseDamage = 20;

        int totalDamage = service.applyMonsterAbility(monster, baseDamage);

        assertThat(totalDamage, is(greaterThanOrEqualTo(baseDamage)));
        
        System.out.println("El Fantasma ha usado su habilidad especial: Invisibilidad.");
      }


      @Test
      void testApplyMonsterAbilityWithVampiro() {
        
        MonsterModel vampiro = new MonsterModel("Vampiro", "Vampiro", 15, 60, 20);
        int baseDamage = vampiro.getMonsterDamage();
        
        int totalDamage = service.applyMonsterAbility(vampiro, baseDamage);
        
        assertThat(totalDamage, is(equalTo(baseDamage)));
        assertThat(vampiro.getMonsterHealth(), is(equalTo(60)));

    }
      @Test
      void testApplyMonsterAbilityWithUnknownType() {
        
        MonsterModel monster = new MonsterModel("Unknown", "Unknown", 10, 60, 10);
        int baseDamage = 10;

        int totalDamage = service.applyMonsterAbility(monster, baseDamage);

        assertThat(totalDamage, is(baseDamage));
      }
      
    @Test
    void testCreateMonster(){
      String type = "Esqueleto";
      String name = "Esqueleto 1";
      int damage = 10;
      int health = 50;
      int bonus = 10;
      MonsterModel result = service.createMonster(name,type,damage,health,bonus);

      assertThat(result.getMonsterName(), is(equalTo(name)));
      assertThat(result.getTypeMonster(), is(equalTo(type)));
      assertThat(result.getMonsterDamage(), is(equalTo(damage)));
      assertThat(result.getMonsterHealth(), is(equalTo(health)));
      assertThat(result.getBonus(), is(equalTo(bonus)));
    }

    @Test
    void testCreateMonsterRandomWithNumber4() {
        Random random = new Random();
        when(random.nextInt(3) + 1).thenReturn(4);
    
        MonsterService monsterService = new MonsterService(repository);
        MonsterModel result = monsterService.createMonsterRandom();
    
        assertThat(result.getMonsterName(), is("Monstruo desconocido"));
        assertThat(result.getMonsterDamage(), is(0));
        assertThat(result.getMonsterHealth(), is(0));
        assertThat(result.getTypeMonster(), is("Monstruo desconocido"));
        assertThat(result.getBonus(), is(0));
    }

    @Test
    void testDeleteMonster() {

        MonsterModel monster = new MonsterModel("TestMonster", 10, 100, "Test", 10);
        //when(repository.findById((long) 1)).thenReturn(Optional.of(monster));

        service.deleteMonster((long) 1);

        verify(repository, times(1)).deleteById((long) 1);
    }


    @Test
    void testGetAllMonsters() {
        List<MonsterModel> monsters = new ArrayList<>();
        MonsterModel esqueleto = new MonsterModel("Esqueleto","Esqueleto", 10, 50, 10);
        MonsterModel fantasma = new MonsterModel("Fantasma","Fantasma", 15, 40, 15);
        MonsterModel vampiro = new MonsterModel("Vampiro","Vampiro", 20, 60, 20);  
        monsters.add(esqueleto);
        monsters.add(fantasma);
        monsters.add(vampiro);  
        when(repository.findAll()).thenReturn(monsters);
        List<MonsterModel> result = service.getAllMonsters();   
        assertThat(result.size(), equalTo(3));
        assertThat(result.get(0).getMonsterName(), equalTo(esqueleto.getMonsterName()));
        assertThat(result, contains(esqueleto, fantasma, vampiro));
    }   
    @Test
    void testGetMonsterById() {
        MonsterModel vampiro = new MonsterModel("Vampiro","Vampiro",20,60,20);  
        when(repository.findById((long) 1)).thenReturn(Optional.of(vampiro));
        MonsterModel result = service.getMonsterById((long) 1); 
        assertThat(result, equalTo(vampiro));
        assertThat(result.getMonsterName(),  equalTo(vampiro.getMonsterName()));
        assertThat(result.getMonsterDamage(), equalTo(vampiro.getMonsterDamage()));
        assertThat(result.getMonsterHealth(), equalTo(vampiro.getMonsterHealth()));
        assertThat(result.getTypeMonster(), equalTo(vampiro.getTypeMonster()));
        assertThat(result.getBonus(), equalTo(vampiro.getBonus()));
    }   

    @Test
    void testGetMonstersByType() {
        // Arrange
        List<MonsterModel> esqueletos = new ArrayList<>();
        MonsterModel esqueleto1 = new MonsterModel("Esqueleto Debil"," Esqueleto",10, 50, 10);
        MonsterModel esqueleto2 = new MonsterModel("Esqueleto Fuerte","Esqueleto", 12, 55, 13);

        esqueletos.add(esqueleto1);
        esqueletos.add(esqueleto2); 
        when(repository.findByTypeMonster("Esqueleto")).thenReturn(esqueletos); 
        // Act
        List<MonsterModel> result = service.getMonstersByType("Esqueleto"); 
        // Assert
        assertThat(result, equalTo(esqueletos));
        assertThat(result.size(), equalTo(2));
        assertThat(result, contains(esqueleto1, esqueleto2));
        assertThat(result.get(0).getTypeMonster(), equalTo("Esqueleto Debil"));
        assertThat(result.get(1).getTypeMonster(), equalTo("Esqueleto Fuerte"));
    }
    
    @Test
    void testHorda() {
        // Arrange
        MonsterModel skeletonMonster = new MonsterModel("Esqueleto", "Esqueleto", 10, 50, 10);
        skeletonMonster.setInvisibleActive(true);
        Random random = new Random();
        //when(random.nextInt(3) + 1).thenReturn(2);
    
        MonsterService monsterService = new MonsterService(repository);
    
        // Act
        int result = monsterService.horda(skeletonMonster, 10);
    
        // Assert
        assertThat(result, is(equalTo(20)));
        assertThat(skeletonMonster.getNumSkeletons(), is(equalTo(2)));
        verify(repository, never()).save(any(MonsterModel.class));
    }


    @Test
    void testInvisible() {
        // Arrange
        MonsterModel monster = new MonsterModel("Fantasma", "Fantasma", 20, 65, 15);
        monster.setInvisibleActive(true);
        int baseDamage = 20;
    
        // Act
        int result = new MonsterService(repository).invisible(monster, baseDamage);
    
        // Assert
        Random random = new Random();
        if (random.nextBoolean()) {
            assertThat(result, is(0));
            System.out.println("El Fantasma se vuelve invisible y evade el ataque de Aiden.");
        } else {
            assertThat(result, is(equalTo((int) (baseDamage * 1.5))));
            System.out.println("El Fantasma ataca desde las sombras.");
        }
    }


    @Test
    void testMonsterIsAlive() {
        // Arrange
        MonsterModel monster = new MonsterModel("TestMonster", 10, 100, "Test", 10);
        monster.setMonsterHealth(50);
    
        // Act
        boolean result = new MonsterService(repository).isMonsterAlive(monster.getId());
    
        // Assert
        assertThat(result, is(true));
    }

    @Test
    void testLifeStealing() {
        // Arrange
        MonsterModel vampiro = new MonsterModel("Vampiro", 15, 60, "Vampiro", 20);
        vampiro.setLifeStealingActive(true);
        int baseDamage = 10;
    
        MonsterService monsterService = new MonsterService(repository);
    
        // Act
        int totalDamage = monsterService.lifeStealing(vampiro, baseDamage);
    
        // Assert
        assertThat(totalDamage, is(equalTo(baseDamage)));
        assertThat(vampiro.getMonsterHealth(), is(equalTo(65)));
        System.out.println("El vampiro te ha robado 5 de vida.");
    }


    @Test
    void testMonsterDamage() {
        // Arrange
        MonsterModel monster = new MonsterModel("TestMonster", 10, 100, "Test", 10);
        MonsterService monsterService = new MonsterService(repository);
    
        // Act
        int result = monsterService.monsterDamage(monster.getId());
    
        // Assert
        assertThat(result, is(equalTo(monster.getMonsterDamage())));
    }
  
    @Test
    void testMonsterReceiveDamage() {
        // Arrange
        MonsterModel monster = new MonsterModel("TestMonster", 10, 100, "Test", 10);
        int damage = 20;
    
        // Act
        MonsterModel result = new MonsterService(repository).monsterReceiveDamage(monster.getId(), damage);
    
        // Assert
        assertThat(result.getMonsterHealth(), is(equalTo(80)));
        assertThat(result.getMonsterName(), is(equalTo("TestMonster")));
        assertThat(result.getMonsterDamage(), is(equalTo(10)));
        assertThat(result.getTypeMonster(), is(equalTo("Test")));
        assertThat(result.getBonus(), is(equalTo(10)));
    }   
    @Test
    void testUpdateMonster() {
        // Arrange
        MonsterModel monster = new MonsterModel("TestMonster", 10, 100, "Test", 10);
        MonsterModel updatedMonster = new MonsterModel("UpdatedMonster", 15, 150, "Updated", 15);
        when(repository.findById((long) 1)).thenReturn(Optional.of(monster));
        when(repository.save(any(MonsterModel.class))).thenReturn(updatedMonster);
    
        // Act
        MonsterModel result = service.updateMonster((long) 1, updatedMonster);
    
        // Assert
        assertThat(result, equalTo(updatedMonster));
        assertThat(result.getMonsterName(),  equalTo(updatedMonster.getMonsterName()));
        assertThat(result.getMonsterDamage(), equalTo(15));
        assertThat(result.getMonsterHealth(), equalTo(150));
        assertThat(result.getTypeMonster(), equalTo("UpdatedMonster"));
        assertThat(result.getBonus(), equalTo(15));
    }
}