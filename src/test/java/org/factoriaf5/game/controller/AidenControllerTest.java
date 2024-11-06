package org.factoriaf5.game.controller;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.services.AidenService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

class AidenControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AidenService aidenService;


    private Aiden aiden;


    @Test
    void testGetAiden() throws Exception {
        // Simular la llamada al servicio y la respuesta
        when(aidenService.getAiden()).thenReturn(aiden);

        // Hacer la petición GET y verificar el estado de la respuesta
        mockMvc.perform(get("/api/aiden"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.aidenName").value("Aiden"))
                .andExpect(jsonPath("$.aidenDescription").value("Es un héroe que posee habilidades."));
    }

   
    @Test
    void testUpdateAiden() throws Exception {
         //Crear un objeto Aiden actualizado
        Aiden updatedAiden = new Aiden();
        updatedAiden.setAidenName("Updated Aiden");
        updatedAiden.setAidenDescription("Descripción actualizada");
        updatedAiden.setAidenAbility("Habilidad actualizada");
        updatedAiden.setAidenHealth(120);
        updatedAiden.setAidenDamage(20);

        //Simular la respuesta del servicio
        when(aidenService.updateAiden(updatedAiden)).thenReturn(updatedAiden);

        // Hacer la petición PUT y verificar el estado de la respuesta
        mockMvc.perform(put("/api/aiden")
                        .contentType(MediaType.APPLICATION_JSON)
                       .content(new ObjectMapper().writeValueAsString(updatedAiden)))
               .andExpect(status().isOk())
             .andExpect(jsonPath("$.aidenName").value("Updated Aiden"))
               .andExpect(jsonPath("$.aidenDescription").value("Descripción actualizada"))
                .andExpect(jsonPath("$.aidenHealth").value(120))
                .andExpect(jsonPath("$.aidenDamage").value(20));
    }
       @Test
    public void testGetAidenNotFound() throws Exception {
        // Simulamos que no se encuentra el objeto Aiden
        when(aidenService.getAiden()).thenThrow(new RuntimeException("Aiden no encontrado"));

        // Hacemos la solicitud GET y verificamos que se lance una excepción
        mockMvc.perform(MockMvcRequestBuilders.get("/api/aiden"))
                .andExpect(status().isNotFound()); // Verificamos que el código de estado sea 404
    }
}