package org.factoriaf5.game.controllers;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.services.AidenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AidenController.class)
public class AidenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AidenService aidenService;

    @InjectMocks
    private AidenController aidenController;

    private Aiden aiden;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        aiden = new Aiden(); // Inicializa un objeto Aiden para las pruebas
        aiden.setAidenHealth(100); // Establece los atributos que necesites
        aiden.setAidenDamage(20);
        // Configura otros atributos según sea necesario
    }

    @Test
    public void testGetAiden() throws Exception {
        when(aidenService.getAiden()).thenReturn(aiden);

        mockMvc.perform(get("/api/aiden")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.aidenHealth").value(100)); // Ajusta según la estructura de Aiden
    }

    @Test
    public void testUpdateAiden() throws Exception {
        Aiden updatedAiden = new Aiden();
        updatedAiden.setAidenHealth(150);
        updatedAiden.setAidenDamage(30);

        when(aidenService.updateAiden(any(Aiden.class))).thenReturn(updatedAiden);

        mockMvc.perform(put("/api/aiden")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"aidenHealth\":150,\"aidenDamage\":30}") // Asegúrate de que coincide con tu clase Aiden
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.aidenHealth").value(150));
    }
}
