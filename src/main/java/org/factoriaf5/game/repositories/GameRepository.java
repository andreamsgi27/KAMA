package org.factoriaf5.game.repositories;

import org.factoriaf5.game.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
