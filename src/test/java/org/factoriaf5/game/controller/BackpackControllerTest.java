package org.factoriaf5.game.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.factoriaf5.game.controllers.BackpackController;
import org.factoriaf5.game.models.Backpack;
import org.factoriaf5.game.models.Items;
import org.factoriaf5.game.services.BackpackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = BackpackController.class)
public class BackpackControllerTest {



    
    @InjectMocks
    private BackpackController backpackController;

    private Backpack testBackpack;
    private Items testItem;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BackpackService backpackService;

    

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testBackpack = new Backpack();
        testBackpack.setId(1L);
        testItem = new Items("Item 1");
        
    }

    @Test
    public void testCreateBackpack() {
        when(backpackService.createBackpack(testBackpack)).thenReturn(testBackpack);

        ResponseEntity<Backpack> response = backpackController.createBackpack(testBackpack);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testBackpack, response.getBody());
    }

    @Test
    public void testGetBackpackFound() {
        when(backpackService.getBackpack(1L)).thenReturn(testBackpack);

        ResponseEntity<Backpack> response = backpackController.getBackpack(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testBackpack, response.getBody());
    }

    @Test
    public void testGetBackpackNotFound() {
        when(backpackService.getBackpack(1L)).thenReturn(null);

        ResponseEntity<Backpack> response = backpackController.getBackpack(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testUpdateBackpack() {
        when(backpackService.updateBackpack(testBackpack)).thenReturn(testBackpack);

        ResponseEntity<Backpack> response = backpackController.updateBackpack(1L, testBackpack);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testBackpack, response.getBody());
    }

    @Test
    public void testDeleteBackpack() {
        doNothing().when(backpackService).deleteBackpack(1L);

        ResponseEntity<Void> response = backpackController.deleteBackpack(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void testAddItemToBackpack() {
        when(backpackService.getBackpack(1L)).thenReturn(testBackpack);
        doNothing().when(backpackService).addItemToBackpack(testBackpack, testItem, 0);

        ResponseEntity<Backpack> response = backpackController.addItemToBackpack(1L, testItem, 0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testBackpack, response.getBody());
        verify(backpackService, times(1)).addItemToBackpack(testBackpack, testItem, 0);
    }

    @Test
    public void testAddItemToBackpackNotFound() {
        when(backpackService.getBackpack(1L)).thenReturn(null);

        ResponseEntity<Backpack> response = backpackController.addItemToBackpack(1L, testItem, 0);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testRemoveItemFromBackpack() {
        when(backpackService.getBackpack(1L)).thenReturn(testBackpack);
        doNothing().when(backpackService).removeItemFromBackpack(testBackpack, 0);

        ResponseEntity<Backpack> response = backpackController.removeItemFromBackpack(1L, 0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testBackpack, response.getBody());
        verify(backpackService, times(1)).removeItemFromBackpack(testBackpack, 0);
    }

    @Test
    public void testRemoveItemFromBackpackNotFound() {
        when(backpackService.getBackpack(1L)).thenReturn(null);

        ResponseEntity<Backpack> response = backpackController.removeItemFromBackpack(1L, 0);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testUpdateItemInBackpack() {
        when(backpackService.getBackpack(1L)).thenReturn(testBackpack);
        doNothing().when(backpackService).updateItemInBackpack(testBackpack, testItem, 0);

        ResponseEntity<Backpack> response = backpackController.updateItemInBackpack(1L, testItem, 0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testBackpack, response.getBody());
        verify(backpackService, times(1)).updateItemInBackpack(testBackpack, testItem, 0);
    }

    @Test
    public void testUpdateItemInBackpackNotFound() {
        when(backpackService.getBackpack(1L)).thenReturn(null);

        ResponseEntity<Backpack> response = backpackController.updateItemInBackpack(1L, testItem, 0);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testGetItemFromBackpack() {
        when(backpackService.getBackpack(1L)).thenReturn(testBackpack);
        when(backpackService.getItemFromBackpack(testBackpack, 0)).thenReturn(testItem);

        ResponseEntity<Items> response = backpackController.getItemFromBackpack(1L, 0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(testItem, response.getBody());
    }

    @Test
    public void testGetItemFromBackpackNotFound() {
        when(backpackService.getBackpack(1L)).thenReturn(null);

        ResponseEntity<Items> response = backpackController.getItemFromBackpack(1L, 0);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
