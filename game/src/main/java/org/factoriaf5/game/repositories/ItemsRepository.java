package org.factoriaf5.game.repositories;
import org.factoriaf5.game.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Long> {
}