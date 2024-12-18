package org.factoriaf5.game.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.factoriaf5.game.controllers.AidenController;
import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.services.AidenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class AidenControllerTest {
    private MockMvc mockMvc;
    @Mock
    private AidenService aidenService;
    @InjectMocks
    private AidenController aidenController;
    private Aiden aiden;
    private ObjectMapper objectMapper = new ObjectMapper();

private Aiden existingAiden;
@BeforeEach
void setup() {
    existingAiden = new Aiden(1L, "Aiden", "Un héroe", "Poder Supremo");
}
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(aidenController).build();
        aiden = new Aiden();
        aiden.setAidenName("Aiden");
        aiden.setAidenDescription("Es un héroe que posee habilidades.");
        aiden.setAidenAbility("Golpe potente y escudo protector");
        aiden.setAidenHealth(100);
        aiden.setAidenDamage(15);
    }
    @Test
    void testGetAiden() throws Exception {
        Aiden aiden = new Aiden(1L, "Aiden", "Es un héroe que posee habilidades.", "Power Strike");
        when(aidenService.getAiden()).thenReturn(aiden);
        String responseContent = mockMvc.perform(get("/api/aiden"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(responseContent).contains("\"aidenName\":\"Aiden\"");
        assertThat(responseContent).contains("\"aidenAbility\":\"Power Strike\"");
    }
}