package org.factoriaf5.game.repositories;

import org.factoriaf5.game.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Long> {
    // Aquí puedes agregar métodos personalizados si necesitas buscar ítems específicos.
}