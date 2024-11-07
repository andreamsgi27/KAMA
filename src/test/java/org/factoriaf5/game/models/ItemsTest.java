package org.factoriaf5.game.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemsTest {
    private Items items;

    @BeforeEach
    void setUp() {
        items = new Items("Spear", "A weapon used for hunting"); // Inicializamos con valores
    }

    @Test
    void testGetItemName() {
        assertEquals("Spear", items.getItemName());
    }
    
    @Test
    void testSetItemName() {
        items.setItemName("Axe");
        assertEquals("Axe", items.getItemName());
    }

    @Test
    void testGetItemDescription(){
        assertEquals("A weapon used for hunting", items.getItemDescription());
    }

    @Test
    void testGetId(){
        items.setId(1L);
        assertEquals(1L, items.getId());
    }
}
