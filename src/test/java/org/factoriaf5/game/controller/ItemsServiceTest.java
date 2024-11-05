package org.factoriaf5.game.controller;

import org.factoriaf5.game.models.Items;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = Items.class)

public class ItemsServiceTest {
    

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test controlador items")
    void testIndex() throws Exception {
    }

}
