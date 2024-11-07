
package org.factoriaf5.game.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.factoriaf5.game.controllers.AidenController;
import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.services.AidenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;//-
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;//-
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;//-

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class AidenControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AidenService aidenService;

    @InjectMocks
    private AidenController aidenController;

    private Aiden aiden;
    @SuppressWarnings("unused")//-
    private ObjectMapper objectMapper = new ObjectMapper();
//+
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(aidenController).build();

        // Crear un objeto Aiden de ejemplo
        aiden = new Aiden();
        aiden.setAidenName("Aiden");
        aiden.setAidenDescription("Es un héroe que posee habilidades.");
        aiden.setAidenAbility("Golpe potente y escudo protector");
        aiden.setAidenHealth(100);
        aiden.setAidenDamage(15);
    }

    @Test
    void testGetAiden() throws Exception {
        // Crear un objeto Aiden de ejemplo
        Aiden aiden = new Aiden(1L, "Aiden", "Es un héroe que posee habilidades.", "Power Strike");

        // Simular la llamada al servicio y la respuesta
        when(aidenService.getAiden()).thenReturn(aiden);

        // Realizar la petición GET y obtener el contenido de la respuesta
        String responseContent = mockMvc.perform(get("/api/aiden"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Aserciones usando AssertJ
        assertThat(responseContent).contains("\"aidenName\":\"Aiden\"");
        assertThat(responseContent).contains("\"aidenAbility\":\"Power Strike\"");
    }

    @Test
    void testDeleteAiden() throws Exception {
        // Realizar la petición DELETE y obtener la respuesta como String
        String responseContent = mockMvc.perform(delete("/api/aiden"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Usamos assertThat para verificar el mensaje de la respuesta
        assertThat(responseContent).isEqualTo("Aiden eliminado exitosamente.");

        // Verificar que el método deleteAiden del servicio haya sido llamado una vez
        verify(aidenService).deleteAiden();
    }
    @Test
    void testCreateAiden() throws Exception {
        // Crear un objeto Aiden para ser enviado en la solicitud POST
        Aiden aiden = new Aiden();
        aiden.setAidenName("Aiden");
       aiden.setAidenDescription("Un héroe");
        aiden.setAidenAbility("Poder Supremo");
    
        String requestContent = objectMapper.writeValueAsString(aiden);

        // Realizar la solicitud POST al endpoint /api/aiden
        String responseContent = mockMvc.perform(post("/api/aiden")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestContent))
                .andExpect(status().isCreated())  // Verificar que el código de estado sea 201 (Created)
                .andReturn()
                .getResponse()
                .getContentAsString();  // Obtener el contenido de la respuesta como String

        // Verificar con assertThat que la respuesta contiene los valores correctos
        assertThat(responseContent).contains("\"aidenName\":\"Aiden\"");
        assertThat(responseContent).contains("\"aidenDescription\":\"Un héroe\"");
        assertThat(responseContent).contains("\"aidenAbility\":\"Poder Supremo\"");
       
    }
    @Test
void testUpdateAiden() throws Exception {
    // Crear un objeto Aiden con los nuevos valores para actualizar
    Aiden updatedAiden = new Aiden();
    updatedAiden.setAidenName("Aiden Actualizado");
    updatedAiden.setAidenDescription("Un héroe mejorado");
    updatedAiden.setAidenAbility("Poder Mejorado");

    // Convertir el Aiden actualizado a JSON
    String requestContent = objectMapper.writeValueAsString(updatedAiden);

    // Realizar la solicitud PUT al endpoint /api/aiden
    String responseContent = mockMvc.perform(put("/api/aiden")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestContent))
                .andExpect(status().isOk())  // Verificar que el código de estado sea 200 (OK)
                .andReturn()
                .getResponse()
                .getContentAsString();  // Obtener el contenido de la respuesta como String

    // Verificar con assertThat que la respuesta contiene los valores actualizados
    assertThat(responseContent).contains("\"aidenName\":\"Aiden Actualizado\"");
    assertThat(responseContent).contains("\"aidenDescription\":\"Un héroe mejorado\"");
    assertThat(responseContent).contains("\"aidenAbility\":\"Poder Mejorado\"");
    
    }