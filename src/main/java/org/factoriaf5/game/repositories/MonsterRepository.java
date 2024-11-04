package org.factoriaf5.game.repositories;

import java.util.List;

import org.factoriaf5.game.models.MonsterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository<MonsterModel, Long> {
    
    public List<MonsterModel> findByTypeMonster(String type);

}