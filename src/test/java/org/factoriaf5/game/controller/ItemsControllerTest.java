package org.factoriaf5.game.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.factoriaf5.game.controllers.ItemsController;
import org.factoriaf5.game.services.ItemsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@WebMvcTest(controllers = ItemsController.class)
public class ItemsControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemsService itemsService;

    @MockBean
    private MonsterService monsterService;

    @Test
    @DisplayName("Test /itemfound de controller")
    void testIndex() throws Exception {
        // Simulamos que el servicio devuelve el valor "Anillo"
        String foundItem = "Anillo";
        when(itemsService.itemFound()).thenReturn(foundItem);

        // Ejecutamos el request GET
        MockHttpServletResponse response = mockMvc.perform(get("/items/itemfound")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        
        // Verificaciones
        assertThat(response.getStatus(), is(200));
        assertThat(response.getContentAsString(), is(foundItem));
    }

    @Test
    @DisplayName("Test /spear")
    void testSpear() throws Exception {
    int aidenDamage = 100;
    int expectedDamage = 110;

    // Simulamos que el servicio devuelve el daño calculado (110 en este caso)
    when(itemsService.spear(aidenDamage)).thenReturn(expectedDamage);

    MockHttpServletResponse response = mockMvc.perform(post("/items/spear")
            .param("aidenDamage", String.valueOf(aidenDamage)) // Pasamos el parámetro en la solicitud
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(200));
    assertThat(response.getContentAsString(), is(String.valueOf(expectedDamage)));
    }


}
