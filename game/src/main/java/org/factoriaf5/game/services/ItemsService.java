package org.factoriaf5.game.services;

import org.factoriaf5.game.Items;
import org.factoriaf5.game.repositories.ItemsRepository;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    ItemsRepository repository;

    public ItemsService(ItemsRepository repository){
        this.repository = repository;
    }

    public List<Items> getAllItems(){
        List<Items> items = repository.findAll()
        return items;
    }

}
