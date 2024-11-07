package org.factoriaf5.game.services;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.AidenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

class AidenServiceTest {

    @Mock
    private AidenRepository aidenRepository;

    @InjectMocks
    private AidenService aidenService;

    private Aiden aiden;
    
    @BeforeEach
    void setUp() {
        // Inicializamos el mock y el servicio
        MockitoAnnotations.openMocks(this);

        // Crear un Aiden de ejemplo
        aiden = new Aiden();
        aiden.setAidenHealth(100);
        aiden.setAidenDamage(15);
        aiden.setAidenName("Aiden");
        aiden.setAidenDescription("Un héroe de gran valentía.");
        aiden.setAidenAbility("Golpe potente");
    }

    @Test
    void testGetAiden() {
        // Simulamos que el repositorio devuelve el objeto Aiden
        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));

        // Ejecutamos el método
        Aiden result = aidenService.getAiden();

        // Verificamos que el resultado es el mismo que el mockeado
        assertNotNull(result);
        assertEquals(aiden.getAidenName(), result.getAidenName());
        assertEquals(aiden.getAidenHealth(), result.getAidenHealth());
    }

    @Test
    void testUpdateAiden() {
        // Crear un Aiden con nuevos detalles
        Aiden updatedAiden = new Aiden();
        updatedAiden.setAidenName("Updated Aiden");
        updatedAiden.setAidenDescription("Descripción actualizada");
        updatedAiden.setAidenAbility("Habilidad actualizada");
        updatedAiden.setAidenHealth(120);
        updatedAiden.setAidenDamage(20);

        // Simulamos que el repositorio devuelve el Aiden actualizado
        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));
        when(aidenRepository.save(any(Aiden.class))).thenReturn(updatedAiden);

        // Ejecutamos el método
        Aiden result = aidenService.updateAiden(updatedAiden);

        // Verificamos que el resultado es el mismo que el actualizado
        assertNotNull(result);
        assertEquals(updatedAiden.getAidenName(), result.getAidenName());
        assertEquals(updatedAiden.getAidenHealth(), result.getAidenHealth());
        assertEquals(updatedAiden.getAidenDamage(), result.getAidenDamage());
    }

    @Test
    void testReceiveDamage() {
        int damage = 20;

        // Simulamos que el repositorio devuelve el Aiden actual
        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));
        when(aidenRepository.save(any(Aiden.class))).thenReturn(aiden);

        // Ejecutamos el método
        aidenService.receiveDamage(damage);

        // Verificamos que la salud de Aiden se reduce correctamente
        assertEquals(80, aiden.getAidenHealth());
    }

    @Test
    void testPowerStrike() {
        // Simulamos que el repositorio devuelve el Aiden actual
        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));
        when(aidenRepository.save(any(Aiden.class))).thenReturn(aiden);

        // Ejecutamos el método
        aidenService.powerStrike();

        // Verificamos que el daño de Aiden aumentó en 10
        assertEquals(25, aiden.getAidenDamage());
    }

    @Test
    void testShield() {
        // Crear un monstruo de ejemplo
        MonsterModel monster = new MonsterModel();
        monster.setMonsterDamage(30);

        // Ejecutamos el método
        int reducedDamage = aidenService.shield(monster);

        // Verificamos que el daño reducido es correcto
        assertEquals(25, reducedDamage);  // 30 - 5 = 25
        assertEquals(25, monster.getMonsterDamage()); // Verificar que el daño del monstruo fue actualizado
    }

    @Test
    void testIncrementHealth() {
        int bonus = 30;

        // Simulamos que el repositorio devuelve el Aiden actual
        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));
        when(aidenRepository.save(any(Aiden.class))).thenReturn(aiden);

        // Ejecutamos el método
        aidenService.incrementHealth(bonus);

        // Verificamos que la salud de Aiden aumentó correctamente
        assertEquals(130, aiden.getAidenHealth());
    }

    @Test
    void testIsAidenAlive() {
        // Simulamos que el repositorio devuelve un Aiden con salud positiva
        when(aidenRepository.findById(1L)).thenReturn(java.util.Optional.of(aiden));

        // Verificamos que Aiden está vivo
        assertTrue(aidenService.isAidenAlive());
    }

    @Test
    public void testAidenDie() {
        // Configurar el mock
        when(aidenRepository.findById(1L)).thenReturn(Optional.of(aiden));

        // Reducir la salud a 0
        aiden.setAidenHealth(0);

        // Comprobar si Aiden muere
        aidenService.aidenDie();
        // Si la salud es 0, la salida será "Aiden ha muerto"
}
}