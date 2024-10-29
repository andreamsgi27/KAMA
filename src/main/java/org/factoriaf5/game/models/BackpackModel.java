package org.factoriaf5.game.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "backpack")
public class BackpackModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_items1")
    private Long iditems1;

    @Column(name = "id_items2")
    private Long iditems2;

    @Column(name = "id_items3")
    private Long iditems3;

    private final String name;

    public BackpackModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}