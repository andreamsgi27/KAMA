package org.factoriaf5.game.models;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AidenTest {

    private Aiden aiden;

    @BeforeEach
    public void setUp() {
        aiden = new Aiden(); // Inicializa un nuevo objeto Aiden antes de cada prueba
    }

    @Test
    public void testInitialValues() {
        // Verifica los valores iniciales
        assertEquals(100, aiden.getAidenHealth(), "La salud inicial de Aiden debe ser 100");
        assertEquals(15, aiden.getAidenDamage(), "El daño inicial de Aiden debe ser 15");
    }

    @Test
    public void testSetAidenHealth() {
        aiden.setAidenHealth(80);
        assertEquals(80, aiden.getAidenHealth(), "La salud de Aiden debe ser actualizada a 80");
    }

    @Test
    public void testSetAidenDamage() {
        aiden.setAidenDamage(25);
        assertEquals(25, aiden.getAidenDamage(), "El daño de Aiden debe ser actualizado a 25");
    }
}