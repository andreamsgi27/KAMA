package org.factoriaf5.game.repositories;// Asegúrate de que GameRepository esté en este paquete

import org.factoriaf5.game.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
