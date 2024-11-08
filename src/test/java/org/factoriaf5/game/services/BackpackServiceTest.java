package org.factoriaf5.game.services;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.factoriaf5.game.models.Backpack;
import org.factoriaf5.game.models.Items;
import org.factoriaf5.game.repositories.BackpackRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BackpackServiceTest {
    
    @InjectMocks
    BackpackService service;

    @Mock
    BackpackRepository repository;

    @Test
    void createBackpackTest() {
        Backpack backpack = new Backpack();
        service.createBackpack(backpack);
        verify(repository, times(1)).save(backpack);
    }

    @Test
    void getBackpackTest() {
        Backpack backpack = new Backpack();
        when(repository.findById(1L)).thenReturn(Optional.of(backpack));
        Backpack result = service.getBackpack(1L);
        assertEquals(backpack, result);
    }

    @Test
    void updateBackpackTest() {
        Backpack backpack = new Backpack();
        service.updateBackpack(backpack);
        verify(repository, times(1)).save(backpack);
    }

    @Test
    void deleteBackpackTest() {
        service.deleteBackpack(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void addItemToBackpackTest() {
        Backpack backpack = new Backpack();
        Items item = new Items("Espada", "Una espada poderosa");
        
        service.addItemToBackpack(backpack, item, 1);
        assertEquals(item, backpack.getItem1());

        service.addItemToBackpack(backpack, item, 2);
        assertEquals(item, backpack.getItem2());

        service.addItemToBackpack(backpack, item, 3);
        assertEquals(item, backpack.getItem3());
    }

    @Test
    void removeItemFromBackpackTest() {
        Backpack backpack = new Backpack();
        Items item = new Items("Espada", "Una espada poderosa");

        backpack.setItem1(item);
        backpack.setItem2(item);
        backpack.setItem3(item);

        service.removeItemFromBackpack(backpack, 1);
        assertNull(backpack.getItem1());

        service.removeItemFromBackpack(backpack, 2);
        assertNull(backpack.getItem2());

        service.removeItemFromBackpack(backpack, 3);
        assertNull(backpack.getItem3());
    }

    @Test
    void updateItemInBackpackTest() {
        Backpack backpack = new Backpack();
        Items item1 = new Items("Espada", "Una espada poderosa");
        Items item2 = new Items("Escudo", "Un escudo resistente");

        backpack.setItem1(item1);
        backpack.setItem2(item1);
        backpack.setItem3(item1);

        service.updateItemInBackpack(backpack, item2, 1);
        assertEquals(item2, backpack.getItem1());

        service.updateItemInBackpack(backpack, item2, 2);
        assertEquals(item2, backpack.getItem2());
        service.updateItemInBackpack(backpack, item2, 3);
        assertEquals(item2, backpack.getItem3());
    }

    @Test
    void getItemFromBackpackTest() {
        Backpack backpack = new Backpack();
        Items item1 = new Items("Espada", "Una espada poderosa");
        Items item2 = new Items("Escudo", "Un escudo resistente");
        Items item3 = new Items("Poción", "Una poción curativa");

        backpack.setItem1(item1);
        backpack.setItem2(item2);
        backpack.setItem3(item3);

        assertEquals(item1, service.getItemFromBackpack(backpack, 1));
        assertEquals(item2, service.getItemFromBackpack(backpack, 2));
        assertEquals(item3, service.getItemFromBackpack(backpack, 3));
    }
}
