package org.factoriaf5.game.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "backpack")
public class Backpack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item1_id") // Conexión con el primer ítem
    private Items item1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item2_id") // Conexión con el segundo ítem
    private Items item2;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item3_id") // Conexión con el tercer ítem
    private Items item3;

    private String name;

    // Constructor sin parámetros para JPA
    public Backpack() {}

    // Constructor con parámetros
    public Backpack(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
