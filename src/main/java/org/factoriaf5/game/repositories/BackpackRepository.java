package org.factoriaf5.game.repositories;

import org.factoriaf5.game.models.Backpack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackpackRepository extends JpaRepository<Backpack, Long> {
}
