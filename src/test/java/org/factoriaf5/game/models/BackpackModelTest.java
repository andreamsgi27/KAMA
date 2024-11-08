
package org.factoriaf5.game.models;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BackpackModelTest {

    private Backpack backpack;
    private Items item1;
    private Items item2;
    private Items item3;

    @BeforeEach
    public void setUp() {
        backpack = new Backpack(1L, "Mochila de pruebas");
        item1 = new Items("Espada", "Una espada poderosa");
        item2 = new Items("Escudo", "Un escudo resistente");
        item3 = new Items("Poción", "Una poción curativa");
    }

    @Test
    public void testAddItem1() {
        backpack.setItem1(item1);
        assertThat(backpack.getItem1()).isEqualTo(item1);
    }

    @Test
    public void testAddItem2() {
        backpack.setItem2(item2);
        assertThat(backpack.getItem2()).isEqualTo(item2);
    }

    @Test
    public void testAddItem3() {
        backpack.setItem3(item3);
        assertThat(backpack.getItem3()).isEqualTo(item3);
    }

    @Test
    public void testBackpackInitialization() {
        assertThat(backpack.getId()).isEqualTo(1L);
        assertThat(backpack.getName()).isEqualTo("Mochila de pruebas");
        assertThat(backpack.getItem1()).isNull();
        assertThat(backpack.getItem2()).isNull();
        assertThat(backpack.getItem3()).isNull();
    }

    @Test
    public void testSetAndGetItems() {
        backpack.setItem1(item1);
        backpack.setItem2(item2);
        backpack.setItem3(item3);

        assertThat(backpack.getItem1()).isEqualTo(item1);
        assertThat(backpack.getItem2()).isEqualTo(item2);
        assertThat(backpack.getItem3()).isEqualTo(item3);
    }

    @Test
    void testSetName() {
        backpack.setName("Mochila");
        assertThat(backpack.getName()).isEqualTo("Mochila");
    }

    @Test
    void setId(){
        backpack.setId(2L);
        assertThat(backpack.getId()).isEqualTo(2L);
    }
}