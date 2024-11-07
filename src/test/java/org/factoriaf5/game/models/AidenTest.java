package org.factoriaf5.game.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AidenTest {

    private Aiden aiden;

   
    @BeforeEach
    void setUp() {
       
        aiden = new Aiden();
    }

    @Test
    void testConstructor() {
        // Verifica que el constructor predeterminado inicializa correctamente los valores
        assertEquals(100, aiden.getAidenHealth(), "La salud inicial debería ser 100.");
        assertEquals(15, aiden.getAidenDamage(), "El daño inicial debería ser 15.");
        assertNull(aiden.getAidenName(), "El nombre debería ser nulo.");
        assertNull(aiden.getAidenDescription(), "La descripción debería ser nula.");
        assertNull(aiden.getAidenAbility(), "La habilidad debería ser nula.");
    }

    @Test
    void testConstructorWithParameters() {
        // Crea un objeto Aiden usando el constructor con parámetros
        Aiden aidenParam = new Aiden(1L, "Aiden", "Héroe valiente", "Golpe potente");

        // Verifica que los valores del objeto Aiden son correctos
        assertEquals(1L, aidenParam.getId(), "El ID debería ser 1.");
        assertEquals("Aiden", aidenParam.getAidenName(), "El nombre debería ser 'Aiden'.");
        assertEquals("Héroe valiente", aidenParam.getAidenDescription(), "La descripción debería ser 'Héroe valiente'.");
        assertEquals("Golpe potente", aidenParam.getAidenAbility(), "La habilidad debería ser 'Golpe potente'.");
        assertEquals(100, aidenParam.getAidenHealth(), "La salud debería ser 100.");
        assertEquals(15, aidenParam.getAidenDamage(), "El daño debería ser 15.");
    }

    @Test
    void testSettersAndGetters() {
        // Usa los setters para modificar las propiedades de Aiden
        aiden.setAidenName("Nuevo Aiden");
        aiden.setAidenDescription("Aiden el héroe");
        aiden.setAidenAbility("Golpe mortal");
        aiden.setAidenHealth(120);
        aiden.setAidenDamage(25);

        // Verifica que los valores fueron actualizados correctamente
        assertEquals("Nuevo Aiden", aiden.getAidenName(), "El nombre debería ser 'Nuevo Aiden'.");
        assertEquals("Aiden el héroe", aiden.getAidenDescription(), "La descripción debería ser 'Aiden el héroe'.");
        assertEquals("Golpe mortal", aiden.getAidenAbility(), "La habilidad debería ser 'Golpe mortal'.");
        assertEquals(120, aiden.getAidenHealth(), "La salud debería ser 120.");
        assertEquals(25, aiden.getAidenDamage(), "El daño debería ser 25.");
    }

    @Test
    void testReceiveDamage() {
        // Inicializa a Aiden con 100 de salud
        aiden.setAidenHealth(100);

        // Aiden recibe 30 de daño
        aiden.receiveDamage(30);

        // Verifica que la salud de Aiden disminuyó correctamente
        assertEquals(70, aiden.getAidenHealth(), "La salud debería ser 70 después de recibir 30 de daño.");
    }

    @Test
    void testReceiveDamageReducesHealth() {
        // Inicializa a Aiden con 100 de salud
        aiden.setAidenHealth(100);

        // Aiden recibe un daño de 150 (lo que debería reducir la salud a un valor negativo)
        aiden.receiveDamage(150);

        // Verifica que la salud no sea negativa (depende de tu lógica de negocio, si se desea evitar)
        assertEquals(-50, aiden.getAidenHealth(), "La salud debería ser -50 después de recibir 150 de daño.");
    }

    @Test
    void testInitialHealth() {
        // Verifica que la salud inicial de Aiden es 100
        assertEquals(100, aiden.getAidenHealth(), "La salud inicial debería ser 100.");
    }

    @Test
    void testInitialDamage() {
        // Verifica que el daño inicial de Aiden es 15
        assertEquals(15, aiden.getAidenDamage(), "El daño inicial debería ser 15.");
    }
    @Test
    void testSetId() {
        // Creamos una nueva instancia de Aiden
        Aiden aiden = new Aiden();

        // Asignamos un valor cualquiera para comprobar
        Long testId = 123L;

        // Llamamos al setter setId, que siempre asignará 1L
        aiden.setId(testId);

        // Verificamos que el valor de id es siempre 1L
        assertThat(aiden.getId()).isEqualTo(1L);
    }
}
