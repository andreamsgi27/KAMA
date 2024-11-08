package org.factoriaf5.game.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "backpack")
public class Backpack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item1_id")
    private Items item1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item2_id")
    private Items item2;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item3_id")
    private Items item3;

    private String name;
    public Backpack() {}


    public Backpack(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Items getItem1() {
        return item1;
    }

    public void setItem1(Items item1) {
        this.item1 = item1;
    }

    public Items getItem2() {
        return item2;
    }

    public void setItem2(Items item2) {
        this.item2 = item2;
    }

    public Items getItem3() {
        return item3;
    }

    public void setItem3(Items item3) {
        this.item3 = item3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}