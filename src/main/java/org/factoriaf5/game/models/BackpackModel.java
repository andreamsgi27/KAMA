package org.factoriaf5.game.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "backpack")
@NoArgsConstructor // Genera automáticamente un constructor sin parámetros
public class BackpackModel {
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
    // Constructor con parámetros
    public BackpackModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}