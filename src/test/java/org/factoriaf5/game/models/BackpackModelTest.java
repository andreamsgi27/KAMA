
/*package org.factoriaf5.game.models;


import static org.junit.jupiter.api.Assertions.*;

import org.factoriaf5.game.repositories.BackpackRepository;
import org.factoriaf5.game.repositories.ItemsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // Asegura que las transacciones se revierten después de cada prueba
public class BackpackModelTest {

    @Autowired
    private BackpackModel backpackModelRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private BackpackRepository backpackRepository;
    

    private Items item;
    private BackpackModel backpack;
    private BackpackModel updatedBackpack;
    private Items updatedItem;
    private BackpackModel deletedBackpack;
    private Items addItem;
    private Items getItem1;
    private Items getItem2;
    private Items getItem3;


    @BeforeEach
    @Transactional
    
    public void setUp() {
        // Preparamos los datos de prueba antes de cada test
        item = new Items("Espada");

        itemsRepository.save(item);  // Guardamos el ítem en la base de datos

        backpack = new BackpackModel(null, "Mochila de prueba");
        backpack.addItem(item, 1);  // Asignamos el ítem a la mochila en la posición 1 // Asignamos el ítem a la mochila
    }

    @Test
public void testCreateBackpack() {
    
    // Guardamos la mochila
    BackpackModel savedBackpack = backpackModelRepository.save(backpack);

    // Comprobamos que la mochila fue guardada correctamente
    assertNotNull(savedBackpack);
    assertEquals("Mochila de prueba", savedBackpack.getName());
    assertNotNull(savedBackpack.getItem1());
    assertEquals("Espada", savedBackpack.getItem1().getName());
}

    @Test
    public void testFindBackpackById() {
        // Guardamos la mochila
        BackpackModel savedBackpack = backpackModelRepository.save(backpack);

        // Recuperamos la mochila desde la base de datos por ID
        BackpackModel foundBackpack = backpackModelRepository.findById(savedBackpack.getId()).orElse(null);

        assertNotNull(foundBackpack);
        assertEquals("Mochila de prueba", foundBackpack.getName());
        assertEquals("Espada", foundBackpack.getItem1().getName());
    }

    @Test
    public void testUpdateBackpack() {
        // Guardamos la mochila
        BackpackModel savedBackpack = backpackModelRepository.save(backpack);

        // Actualizamos el nombre de la mochila
        savedBackpack.setName("Mochila actualizada");
        BackpackModel updatedBackpack = backpackModelRepository.save(savedBackpack);

        assertNotNull(updatedBackpack);
        assertEquals("Mochila actualizada", updatedBackpack.getName());
    }

    @Test
    public void testDeleteBackpack() {
        // Guardamos la mochila
        BackpackModel savedBackpack = backpackModelRepository.save(backpack);

        // Eliminamos la mochila
        backpackModelRepository.deleteById(savedBackpack.getId());

        // Comprobamos que la mochila ya no existe en la base de datos
        assertFalse(backpackModelRepository.findById(savedBackpack.getId()).isPresent());
    }
}/* */
package org.factoriaf5.game.models;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BackpackModelTest {

    private BackpackModel backpack;
    
    @BeforeEach
    public void setUp() {
        // Inicializamos un BackpackModel antes de cada prueba
        backpack = new BackpackModel(1L, "Mochila de pruebas");
    }

    @Test
    public void testConstructorWithParameters() {
        // Verificar que el constructor con parámetros inicializa los valores correctamente
        assertThat(backpack.getId()).isEqualTo(1L);
        assertThat(backpack.getName()).isEqualTo("Mochila de pruebas");
    }

    @Test
    public void testSetName() {
        // Cambiar el nombre de la mochila y verificar que se actualiza correctamente
        backpack.setName("Nueva Mochila");
        assertThat(backpack.getName()).isEqualTo("Nueva Mochila");
    }

    @Test
    public void testAddItemAtPosition1() {
        // Crear un ítem y añadirlo a la posición 1
        Items item1 = new Items("Espada", "Una espada poderosa");
        backpack.addItem(item1, 1);
        assertThat(backpack.getItem1()).isEqualTo(item1);
    }

    @Test
    public void testAddItemAtPosition2() {
        // Crear un ítem y añadirlo a la posición 2
        Items item2 = new Items("Escudo", "Un escudo resistente");
        backpack.addItem(item2, 2);
        assertThat(backpack.getItem2()).isEqualTo(item2);
    }

    
    @Test
    public void testAddItemAtPosition3() {
        // Crear un ítem y añadirlo a la posición 3
        Items item3 = new Items("Poción", "Una poción curativa");
        backpack.addItem(item3, 3);
        assertThat(backpack.getItem3()).isEqualTo(item3);
    }

    @Test
    public void testAddItemAtInvalidPosition() {
        // Verificar que no se añade ningún ítem si la posición es inválida
        Items item = new Items("Amuleto", "Un amuleto místico");
        backpack.addItem(item, 4);  // Posición inválida
        assertThat(backpack.getItem1()).isNull();
        assertThat(backpack.getItem2()).isNull();
        assertThat(backpack.getItem3()).isNull();
    }

    @Test
    public void testUnsupportedOperationExceptionInNoArgsConstructor() {
        // Verificar que el constructor sin parámetros lanza UnsupportedOperationException
        assertThrows(UnsupportedOperationException.class, () -> new BackpackModel());
    }

    @Test
    public void testUnsupportedOperationExceptionInSetItem1() {
        // Verificar que el método setItem1 lanza UnsupportedOperationException
        Items item = new Items("Espada", "Una espada poderosa");
        assertThrows(UnsupportedOperationException.class, () -> backpack.setItem1(item));
    }
}
