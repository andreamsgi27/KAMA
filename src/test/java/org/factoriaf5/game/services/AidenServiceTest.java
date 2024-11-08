package org.factoriaf5.game.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.AidenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AidenServiceTest {

    @Mock
    private AidenRepository aidenRepository;

    @InjectMocks
    private AidenService aidenService;

    private Aiden aiden;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        aiden = new Aiden();
        aiden.setAidenHealth(100);
        aiden.setAidenDamage(15);
        aiden.setAidenName("Aiden");
        aiden.setAidenDescription("Un héroe de gran valentía.");
        aiden.setAidenAbility("Golpe potente");
    }

    @Test
    void testGetAiden() {
        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));


        Aiden result = aidenService.getAiden();


        assertNotNull(result);
        assertEquals(aiden.getAidenName(), result.getAidenName());
        assertEquals(aiden.getAidenHealth(), result.getAidenHealth());
    }

    @Test
    void testUpdateAiden() {
        Aiden updatedAiden = new Aiden();
        updatedAiden.setAidenName("Updated Aiden");
        updatedAiden.setAidenDescription("Descripción actualizada");
        updatedAiden.setAidenAbility("Habilidad actualizada");
        updatedAiden.setAidenHealth(120);
        updatedAiden.setAidenDamage(20);

        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));
        when(aidenRepository.save(any(Aiden.class))).thenReturn(updatedAiden);

        Aiden result = aidenService.updateAiden(updatedAiden);

        assertNotNull(result);
        assertEquals(updatedAiden.getAidenName(), result.getAidenName());
        assertEquals(updatedAiden.getAidenHealth(), result.getAidenHealth());
        assertEquals(updatedAiden.getAidenDamage(), result.getAidenDamage());
    }

    @Test
    void testReceiveDamage() {
        int damage = 20;

        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));
        when(aidenRepository.save(any(Aiden.class))).thenReturn(aiden);

        aidenService.receiveDamage(damage);

        assertEquals(80, aiden.getAidenHealth());
    }

    @Test
    void testPowerStrike() {
        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));
        when(aidenRepository.save(any(Aiden.class))).thenReturn(aiden);

        aidenService.powerStrike();

        assertEquals(25, aiden.getAidenDamage());
    }

    @Test
    void testShield() {
        MonsterModel monster = new MonsterModel("Esqueleto", "Esqueleto", 30, 20, 10);

        int reducedDamage = aidenService.shield(monster);

        assertEquals(25, reducedDamage);
        assertEquals(25, monster.getMonsterDamage());
    }

    @Test
    void testIncrementHealth() {
        int bonus = 30;

        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));
        when(aidenRepository.save(any(Aiden.class))).thenReturn(aiden);

        aidenService.incrementHealth(bonus);

        assertEquals(130, aiden.getAidenHealth());
    }

    @Test
    void testIsAidenAlive() {
        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));

        assertTrue(aidenService.isAidenAlive());
    }

    @Test
    public void testAidenDie() {
        when(aidenRepository.findById(1L)).thenReturn(Optional.of(aiden));

        aiden.setAidenHealth(0);

        aidenService.aidenDie();
}
}