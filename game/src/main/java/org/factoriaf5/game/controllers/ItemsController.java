package org.factoriaf5.game.controllers;
import org.factoriaf5.game.models.*;
import org.factoriaf5.game.services.ItemsService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController{
    private ItemsService services;

    public ItemsController(ItemsService services){
        this.services = services;
    }

    @GetMapping(path = "/items")
    public List<Item> getItems(){
        return services.getItems();
        }
}
