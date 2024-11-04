package org.factoriaf5.game.services;

import org.factoriaf5.game.models.Backpack;
import org.factoriaf5.game.models.Items;
import org.factoriaf5.game.repositories.BackpackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackpackService {

    @Autowired
    private BackpackRepository backpackRepository;

    public Backpack createBackpack(Backpack backpack) {
        return backpackRepository.save(backpack);
    }

    public Backpack getBackpack(Long id) {
        return backpackRepository.findById(id).orElse(null);
    }

    public Backpack updateBackpack(Backpack backpack) {
        return backpackRepository.save(backpack);
    }

    public void deleteBackpack(Long id) {
        backpackRepository.deleteById(id);
    }

    public void addItemToBackpack(Backpack backpack, Items item, int index) {
        switch (index) {
            case 1 -> backpack.setItem1(item);
            case 2 -> backpack.setItem2(item);
            case 3 -> backpack.setItem3(item);
            default -> throw new IllegalArgumentException("Índice inválido. Usa 1, 2 o 3.");
        }
        updateBackpack(backpack);
    }

    public void removeItemFromBackpack(Backpack backpack, int index) {
        switch (index) {
            case 1 -> backpack.setItem1(null);
            case 2 -> backpack.setItem2(null);
            case 3 -> backpack.setItem3(null);
            default -> throw new IllegalArgumentException("Índice inválido. Usa 1, 2 o 3.");
        }
        updateBackpack(backpack);
    }

    public void updateItemInBackpack(Backpack backpack, Items newItem, int index) {
        switch (index) {
            case 1 -> backpack.setItem1(newItem);
            case 2 -> backpack.setItem2(newItem);
            case 3 -> backpack.setItem3(newItem);
            default -> throw new IllegalArgumentException("Índice inválido. Usa 1, 2 o 3.");
        }
        updateBackpack(backpack);
    }

    public Items getItemFromBackpack(Backpack backpack, int index) {
        switch (index) {
            case 1 -> {
                return backpack.getItem1();
            }
            case 2 -> {
                return backpack.getItem2();
            }
            case 3 -> {
                return backpack.getItem3();
            }
            default -> throw new IllegalArgumentException("Índice inválido. Usa 1, 2 o 3.");
        }
    }
}