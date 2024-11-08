package org.factoriaf5.game.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AidenTest {

    private Aiden aiden;

   
    @BeforeEach
    void setUp() {
       
        aiden = new Aiden();
    }

    @Test
    void testConstructor() {
        assertEquals(100, aiden.getAidenHealth(), "La salud inicial debería ser 100.");
        assertEquals(15, aiden.getAidenDamage(), "El daño inicial debería ser 15.");
        assertNull(aiden.getAidenName(), "El nombre debería ser nulo.");
        assertNull(aiden.getAidenDescription(), "La descripción debería ser nula.");
        assertNull(aiden.getAidenAbility(), "La habilidad debería ser nula.");
    }

    @Test
    void testConstructorWithParameters() {
        Aiden aidenParam = new Aiden(1L, "Aiden", "Héroe valiente", "Golpe potente");

        assertEquals(1L, aidenParam.getId(), "El ID debería ser 1.");
        assertEquals("Aiden", aidenParam.getAidenName(), "El nombre debería ser 'Aiden'.");
        assertEquals("Héroe valiente", aidenParam.getAidenDescription(), "La descripción debería ser 'Héroe valiente'.");
        assertEquals("Golpe potente", aidenParam.getAidenAbility(), "La habilidad debería ser 'Golpe potente'.");
        assertEquals(100, aidenParam.getAidenHealth(), "La salud debería ser 100.");
        assertEquals(15, aidenParam.getAidenDamage(), "El daño debería ser 15.");
    }

    @Test
    void testSettersAndGetters() {
        aiden.setAidenName("Nuevo Aiden");
        aiden.setAidenDescription("Aiden el héroe");
        aiden.setAidenAbility("Golpe mortal");
        aiden.setAidenHealth(120);
        aiden.setAidenDamage(25);

        assertEquals("Nuevo Aiden", aiden.getAidenName(), "El nombre debería ser 'Nuevo Aiden'.");
        assertEquals("Aiden el héroe", aiden.getAidenDescription(), "La descripción debería ser 'Aiden el héroe'.");
        assertEquals("Golpe mortal", aiden.getAidenAbility(), "La habilidad debería ser 'Golpe mortal'.");
        assertEquals(120, aiden.getAidenHealth(), "La salud debería ser 120.");
        assertEquals(25, aiden.getAidenDamage(), "El daño debería ser 25.");
    }

    @Test
    void testReceiveDamage() {
        aiden.setAidenHealth(100);

        aiden.receiveDamage(30);

        assertEquals(70, aiden.getAidenHealth(), "La salud debería ser 70 después de recibir 30 de daño.");
    }

    @Test
    void testReceiveDamageReducesHealth() {
        aiden.setAidenHealth(100);

        aiden.receiveDamage(150);

        assertEquals(-50, aiden.getAidenHealth(), "La salud debería ser -50 después de recibir 150 de daño.");
    }

    @Test
    void testInitialHealth() {
        assertEquals(100, aiden.getAidenHealth(), "La salud inicial debería ser 100.");
    }

    @Test
    void testInitialDamage() {
        assertEquals(15, aiden.getAidenDamage(), "El daño inicial debería ser 15.");
    }
}
