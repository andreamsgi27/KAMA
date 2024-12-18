package org.factoriaf5.game.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.factoriaf5.game.models.Items;
import org.factoriaf5.game.models.MonsterModel;
import org.factoriaf5.game.repositories.ItemsRepository;
import org.factoriaf5.game.repositories.MonsterRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemsServicesTest {
    
    @InjectMocks
    ItemsService service;

    @Mock
    ItemsRepository repository;
    
    @Mock
    private MonsterRepository mrepository;

    @Test
    void testgetAllItems(){
        
        List<Items> items = new ArrayList<>();
        Items potion = new Items("Poción", "Cura a Aiden");
        Items spear = new Items("Lanza", "Arma de Aiden");
        items.add(potion);
        items.add(spear);

        when(repository.findAll()).thenReturn(items);
        List<Items> result = service.getAllItems();

        assertThat(result.size(),equalTo(2));
        assertThat(result.get(0).getItemName(), equalTo("Poción"));
        assertThat(result, contains(potion, spear));

    }

    @Test
    void itemFound() {
        String result = service.itemFound();

        assertThat(result.equals("Lanza") || result.equals("Poción") || result.equals("Ajo") || result.equals("Gafas") || result.equals("Silbato"), equalTo(true));

    }

    @Test
    void spear() {
        int aidenDamage = 20;
        int result = service.spear(aidenDamage);
        assertThat(result, equalTo(30));
    }

    @Test
    void potion(){
        int aidenHealth = 10;
        int result = service.potion(aidenHealth);
        assertThat(result, equalTo(30));
    }

    @Test
    void testGlassesTrue() {
    MonsterModel monster = new MonsterModel();
    monster.setId(1L);
    monster.setTypeMonster("Fantasma");
    when(mrepository.findById(1L)).thenReturn(Optional.of(monster));


    boolean result = service.glasses(1L);


    assertThat(result, equalTo(true));
    assertThat(monster.isInvisibleActive(), equalTo(false));
    }

    @Test
    void testGlassesFalse() {
    MonsterModel monster = new MonsterModel();
    monster.setId(1L);
    monster.setTypeMonster("Vampiro");
    when(mrepository.findById(1L)).thenReturn(Optional.of(monster));

    boolean result = service.glasses(1L);

    assertThat(result, equalTo(false));
    }

    @Test
    void testGarlicTrue() {
    MonsterModel monster = new MonsterModel();
    monster.setId(1L);
    monster.setTypeMonster("Vampiro");
    when(mrepository.findById(1L)).thenReturn(Optional.of(monster));

    boolean result = service.garlic(1L);

    assertThat(result, equalTo(true));
    assertThat(monster.isLifeStealingActive(), equalTo(false));
    }

    @Test
    void testGarlicFalse() {
    MonsterModel monster = new MonsterModel();
    monster.setId(1L);
    monster.setTypeMonster("Fantasma");
    when(mrepository.findById(1L)).thenReturn(Optional.of(monster));

    boolean result = service.garlic(1L);

    assertThat(result, equalTo(false));
    }

    @Test
    void testWhistleTrue() {
    MonsterModel monster = new MonsterModel();
    monster.setId(1L);
    monster.setTypeMonster("Esqueleto");
    when(mrepository.findById(1L)).thenReturn(Optional.of(monster));

    boolean result = service.whistle(1L);

    assertThat(result, equalTo(true));
    assertThat(monster.getNumSkeletons(), equalTo(1));
    }

    @Test
    void testWhistleFalse() {
    MonsterModel monster = new MonsterModel();
    monster.setId(1L);
    monster.setTypeMonster("Fantasma");
    when(mrepository.findById(1L)).thenReturn(Optional.of(monster));

    boolean result = service.whistle(1L);

    assertThat(result, equalTo(false));
    }



}
