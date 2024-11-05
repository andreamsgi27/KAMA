package org.factoriaf5.game.services;

import org.factoriaf5.game.repositories.ItemsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ItemsServicesTest {
    
    @InjectMocks
    ItemsService service;

    @Mock
    ItemsRepository repository;

    @Test
    void testgetall(){
        
    }
}
