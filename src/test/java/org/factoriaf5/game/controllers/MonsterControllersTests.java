package org.factoriaf5.game.controllers;

import org.factoriaf5.game.controllers.MonsterControllers;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.services.MonsterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(controllers = MonsterControllers.class)
public class MonsterControllersTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MonsterService monsterService;
@Test
@DisplayName("create a new monster")
void testCreateMonster() throws Exception {
    MonsterModel monster = new MonsterModel();

    monster.setTypeMonster("Esqueleto");
    monster.setMonsterName("Esqueleto");
    monster.setMonsterHealth(100);
    monster.setMonsterDamage(10);
    monster.setBonus(0);

     when(monsterService.createMonster(anyString(), anyString(), anyInt(), anyInt(), anyInt())).thenReturn(monster);

    MockHttpServletResponse response = mockMvc.perform(post("/monsters/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"typeMonster\":\"Esqueleto\",\"monsterName\":\"Esqueleto\",\"monsterDamage\":10,\"monsterHealth\":100,\"bonus\":0}")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andReturn()
            .getResponse();

    assertThat(response.getStatus()).isEqualTo(201);
}

    @Test
    @DisplayName("return a monster by ID")
    void testGetMonsterById() throws Exception {
        MonsterModel monster = new MonsterModel();
        when(monsterService.getMonsterById(1L)).thenReturn(monster);

        MockHttpServletResponse response = mockMvc.perform(get("/monsters/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    @DisplayName("return all monsters")
    void testGetAllMonsters() throws Exception {
        List<MonsterModel> monsters = Arrays.asList(new MonsterModel(),
            new MonsterModel()
        );
        when(monsterService.getAllMonsters()).thenReturn(monsters);

       MockHttpServletResponse response = mockMvc.perform(get("/monsters/getall")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    @DisplayName("update a monster")
    void testUpdateMonster() throws Exception {
        MonsterModel updatedMonster = new MonsterModel();
        when(monsterService.updateMonster(eq(1L), any(MonsterModel.class))).thenReturn(updatedMonster);

        MockHttpServletResponse response = mockMvc.perform(put("/monsters/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"typeMonster\":\"Vampiro\",\"monsterName\":\"Vampiro\",\"monsterDamage\":15,\"monsterHealth\":60,\"bonus\":20}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    @DisplayName("delete a monster")
    void testDeleteMonster() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(delete("/monsters/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(204);
    }

    @Test
    @DisplayName("return monster attack damage")
    void testMonsterAttack() throws Exception {
        when(monsterService.monsterDamage(1L)).thenReturn(10);

        MockHttpServletResponse response = mockMvc.perform(post("/monsters/1/attack")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    @DisplayName("handle monster receiving damage")
    void testMonsterReceiveDamage() throws Exception {
        MonsterModel damagedMonster = new MonsterModel();
        when(monsterService.monsterReceiveDamage(eq(1L), eq(20))).thenReturn(damagedMonster);

        MockHttpServletResponse response = mockMvc.perform(post("/monsters/1/receive-damage")
                .param("damage", "20")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    @DisplayName("check if monster is alive")
    void testIsMonsterAlive() throws Exception {
        when(monsterService.isMonsterAlive(1L)).thenReturn(true);

        MockHttpServletResponse response = mockMvc.perform(get("/monsters/1/is-alive")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
    }
}