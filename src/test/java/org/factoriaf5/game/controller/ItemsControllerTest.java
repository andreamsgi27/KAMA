package org.factoriaf5.game.controller;

import org.factoriaf5.game.controllers.ItemsController;
import org.factoriaf5.game.services.ItemsService;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ItemsController.class)
public class ItemsControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemsService itemsService;

    @Test
    @DisplayName("Test /itemfound de controller")
    void testIndex() throws Exception {
        // Simulamos que el servicio devuelve el valor "Anillo"
        String foundItem = "Ajo";
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

    when(itemsService.spear(aidenDamage)).thenReturn(expectedDamage);

    MockHttpServletResponse response = mockMvc.perform(post("/items/spear")
            .param("aidenDamage", String.valueOf(aidenDamage))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(200));
    assertThat(response.getContentAsString(), is(String.valueOf(expectedDamage)));
    }

    @Test
    @DisplayName("Test /potion")
    void testPotion() throws Exception {
    int aidenHealth = 50;
    int aidenHealthFinal = 70;

    when(itemsService.potion(aidenHealth)).thenReturn(aidenHealthFinal);

    MockHttpServletResponse response = mockMvc.perform(post("/items/potion")
            .param("aidenHealth", String.valueOf(aidenHealth))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(200));
    assertThat(response.getContentAsString(), is(String.valueOf(aidenHealthFinal)));
    }

    @Test
    @DisplayName("Test /garlic, ajo lo puedes usar")
    void testGarlic() throws Exception {
    Long monsterId = 1L;
    boolean success = true;
    String msgSuccess = "El ajo desactiva la habilidad de robo de vida del vampiro.";

    when(itemsService.garlic(monsterId)).thenReturn(success);

    MockHttpServletResponse response = mockMvc.perform(post("/items/garlic")
            .param("monsterId", String.valueOf(monsterId))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(200));
    assertThat(response.getContentAsString(), is(String.valueOf(msgSuccess)));
    }

    @Test
    @DisplayName("Test /garlic el ajo no lo puedes usar")
    void testGarlicFalse() throws Exception {
    Long monsterId = 1L;
    boolean success = false;
    String msgFailure = "No se pudo aplicar el ajo.";



    when(itemsService.garlic(monsterId)).thenReturn(success);

    MockHttpServletResponse response = mockMvc.perform(post("/items/garlic")
            .param("monsterId", String.valueOf(monsterId)) 
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(200));
    assertThat(response.getContentAsString(), is(String.valueOf(msgFailure)));
    }

    @Test
    @DisplayName("Test /glasses puedes usarlas")
    void testGlasses() throws Exception {
    Long monsterId = 1L;
    boolean success = true;
    String msg = "Las gafas desactivan la invisibilidad del fantasma.";



    
    when(itemsService.glasses(monsterId)).thenReturn(success);

    MockHttpServletResponse response = mockMvc.perform(post("/items/glasses")
            .param("monsterId", String.valueOf(monsterId))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(200));
    assertThat(response.getContentAsString(), is(String.valueOf(msg)));
    }

    @Test
    @DisplayName("Test /glasses no puedes usarlas")
    void testGlassesFalse() throws Exception {
    Long monsterId = 1L;
    boolean success = false;
    String msg = "No se pudo aplicar las gafas.";



    
    when(itemsService.glasses(monsterId)).thenReturn(success);

    MockHttpServletResponse response = mockMvc.perform(post("/items/glasses")
            .param("monsterId", String.valueOf(monsterId))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(200));
    assertThat(response.getContentAsString(), is(String.valueOf(msg)));
    }

    @Test
    @DisplayName("Test /whistle puedes usarlo")
    void testWhistle() throws Exception {
    Long monsterId = 1L;
    boolean success = true;
    String msg = "El silbato dispersa la horda de esqueletos.";



    
    when(itemsService.whistle(monsterId)).thenReturn(success);

    MockHttpServletResponse response = mockMvc.perform(post("/items/whistle")
            .param("monsterId", String.valueOf(monsterId))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(200));
    assertThat(response.getContentAsString(), is(String.valueOf(msg)));
    }

    @Test
    @DisplayName("Test /whistle puedes usarlo")
    void testWhistleFalse() throws Exception {
    Long monsterId = 1L;
    boolean success = false;
    String msg = "No se pudo usar el silbato.";



    
    when(itemsService.whistle(monsterId)).thenReturn(success);

    MockHttpServletResponse response = mockMvc.perform(post("/items/whistle")
            .param("monsterId", String.valueOf(monsterId))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(200));
    assertThat(response.getContentAsString(), is(String.valueOf(msg)));
    }


}
