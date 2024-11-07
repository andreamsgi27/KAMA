
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

import org.factoriaf5.game.services.BackpackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BackpackModelTest {

    private Backpack backpack;
    private Items item1;
    private Items item2;
    private Items item3;

    @BeforeEach
    public void setUp() {
        // Inicializamos los objetos necesarios para los tests
        backpack = new Backpack(1L, "Mochila de pruebas");
        item1 = new Items("Espada", "Una espada poderosa");
        item2 = new Items("Escudo", "Un escudo resistente");
        item3 = new Items("Poción", "Una poción curativa");
    }

    @Test
    public void testAddItem1() {
        // Asignamos item1 al primer slot de la mochila
        backpack.setItem1(item1);
        assertThat(backpack.getItem1()).isEqualTo(item1);
    }

    @Test
    public void testAddItem2() {
        // Asignamos item2 al segundo slot de la mochila
        backpack.setItem2(item2);
        assertThat(backpack.getItem2()).isEqualTo(item2);
    }

    @Test
    public void testAddItem3() {
        // Asignamos item3 al tercer slot de la mochila
        backpack.setItem3(item3);
        assertThat(backpack.getItem3()).isEqualTo(item3);
    }

    @Test
    public void testBackpackInitialization() {
        // Verificamos que la mochila tiene los atributos iniciales correctos
        assertThat(backpack.getId()).isEqualTo(1L);
        assertThat(backpack.getName()).isEqualTo("Mochila de pruebas");
        assertThat(backpack.getItem1()).isNull();
        assertThat(backpack.getItem2()).isNull();
        assertThat(backpack.getItem3()).isNull();
    }

    @Test
    public void testSetAndGetItems() {
        // Asignamos los ítems y verificamos que cada getter devuelve el ítem correcto
        backpack.setItem1(item1);
        backpack.setItem2(item2);
        backpack.setItem3(item3);

        assertThat(backpack.getItem1()).isEqualTo(item1);
        assertThat(backpack.getItem2()).isEqualTo(item2);
        assertThat(backpack.getItem3()).isEqualTo(item3);
    }

    @Test
    void testSetName() {
        // Asignamos un nuevo nombre a la mochila
        backpack.setName("Mochila");
        assertThat(backpack.getName()).isEqualTo("Mochila");
    }

    @Test
    void setId(){
        // Asignamos un nuevo id a la mochila
        backpack.setId(2L);
        assertThat(backpack.getId()).isEqualTo(2L);
    }
}