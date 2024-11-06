package org.factoriaf5.game.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.factoriaf5.game.models.Items;
import org.factoriaf5.game.repositories.ItemsRepository;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemsServicesTest {
    
    @InjectMocks
    ItemsService service;

    @Mock
    ItemsRepository repository;

    @Mock
    private Random random;
    //hay que mockear el random en los tests

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
}
