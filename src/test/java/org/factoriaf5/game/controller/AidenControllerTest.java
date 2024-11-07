package org.factoriaf5.game.controller;

import org.factoriaf5.game.controllers.AidenController;
import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.services.AidenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class AidenControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AidenService aidenService;

    @InjectMocks
    private AidenController aidenController;

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
}