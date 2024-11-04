package org.factoriaf5.game.repositories;

import org.factoriaf5.game.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    // Aquí puedes añadir consultas personalizadas si lo necesitas
}
