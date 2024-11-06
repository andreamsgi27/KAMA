package org.factoriaf5.game.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.MonsterRepository;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;




@ExtendWith(MockitoExtension.class)

public class MonsterServiceTest {
    
    // Injectamos en el servicio el mock del repositorio.
    @InjectMocks
    MonsterService service;

    @Mock
    MonsterRepository repository;

    @BeforeEach
    void setUp() {
        this.service = new MonsterService(repository);
    }

    @Test
    void TestAttackMonster(){
        MonsterModel monster = new MonsterModel("Vampiro", 20, 60, "Vampiro", 20);
        AidenService heroe = mock(AidenService.class);
    
        when(service.applyMonsterAbility(monster, monster.getMonsterDamage())).thenReturn(40);
        
        service.monsterAttack(monster, heroe);
    
        verify(heroe).receiveDamage(40);
        verify(System.out).println("El " + monster.getMonsterName() + " ataca a Aiden");

        assertThat(monster.getMonsterHealth(), lessThanOrEqualTo(60 - 40)); // Assuming monster's health decreases by 40 after attack
        assertThat(monster.isMonsterAlive(), is(true));
    }
/*    @Test
    void testApplyMonsterAbility() {

    }

    @Test
    void testCreateMonster() {

    }

    @Test
    void testCreateMonsterRandom() {

    }

    @Test
    void testDeleteMonster() {

    }*/

    @Test
    void testGetAllMonsters() {
        List<MonsterModel> monsters = new ArrayList<>();
        MonsterModel esqueleto = new MonsterModel("Esqueleto", 10, 50, "Esqueleto", 10);
        MonsterModel fantasma = new MonsterModel("Fantasma", 15, 40, "Fantasma", 15);
        MonsterModel vampiro = new MonsterModel("Vampiro", 20, 60, "Vampiro", 20);
    
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
        MonsterModel vampiro = new MonsterModel("Vampiro",20,60,"Vampiro",20);

        when(repository.findById((long) 1)).thenReturn(Optional.of(vampiro));
        MonsterModel result = service.getMonsterById((long) 1);

        assertThat(result, equalTo(vampiro));
        assertThat(result.getMonsterName(),  equalTo(vampiro.getMonsterName()));
        assertThat(result.getMonsterDamage(), equalTo(20));
        assertThat(result.getMonsterHealth(), equalTo(60));
        assertThat(result.getTypeMonster(), equalTo("Vampiro"));
        assertThat(result.getBonus(), equalTo(20));
    }

    
    @Test
    void testGetMonstersByType() {
        // Arrange
        List<MonsterModel> esqueletos = new ArrayList<>(); 
        MonsterModel esqueleto1 = new MonsterModel("Esqueleto Debil", 10, 50, "Esqueleto", 10);
        MonsterModel esqueleto2 = new MonsterModel("Esqueleto Fuerte", 12, 55, "Esqueleto", 13);
        
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
    /*
    @Test
    void testHorda() {

    }

    @Test
    void testInvisible() {

    }

    @Test
    void testIsMonsterAlive() {

    }

    @Test
    void testIsMonsterAlive2() {

    }

    @Test
    void testLifeStealing() {

    }

    @Test
    void testMonsterDamage() {

    }

    @Test
    void testMonsterDamage2() {

    }

    @Test
    void testMonsterReceiveDamage() {

    }

    @Test
    void testMonsterReceiveDamage2() {

    }

    @Test
    void testUpdateMonster() {

    }*/
}
