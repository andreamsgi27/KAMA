package org.factoriaf5.game.repositories;

import org.factoriaf5.game.MonsterModel.;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
    List<Monster> ;
}