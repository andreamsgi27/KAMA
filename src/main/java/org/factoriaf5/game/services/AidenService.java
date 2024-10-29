package org.factoriaf5.game.services;


    
import java.util.List;

import org.factoriaf5.game.models.Aiden;
import org.factoriaf5.game.repositories.AidenRepository;
import org.springframework.stereotype.Service;
@Service
public class AidenService{
   
    AidenRepository repository;

    public AidenService(AidenRepository repository) {
        this.repository = repository;
    }
    
      public List<Aiden> getAll(){
        List<Aiden> aiden = repository.findAll();
      
        return aiden;
    }
}
