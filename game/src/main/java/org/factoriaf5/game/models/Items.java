package org.factoriaf5.game.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_items")
    private Long id;
    private String name;
    private String description;

    public Items(Long id, String name, String description){
        this.id =  id;
        this.name = name;
        this.description = description;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
        }
    
    public String getDescription(){
        return description;
    }



}
