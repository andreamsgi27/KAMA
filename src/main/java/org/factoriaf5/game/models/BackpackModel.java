package org.factoriaf5.game.models;

package org.factoriaf5.game.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "backpack")
@Data
public class BackpackModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relaciones con los elementos (ítems) en la mochila
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Items> items = new ArrayList<>();

    // Campos específicos para 5 espacios de ítems en la mochila
    @Column(name = "id_items1")
    private Long iditems1;
    
    @Column(name = "id_items2")
    private Long iditems2;
    
    @Column(name = "id_items3")
    private Long iditems3;
    
    @Column(name = "id_items4")
    private Long iditems4;
        
    @Column(name = "id_items5")
    private Long iditems5;

    private String name;

    // Constructor sin parámetros para JPA
    public BackpackModel() {}

    // Constructor con parámetros
    public BackpackModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Métodos para obtener y asignar ítems en cada espacio

    public Long getIditems1() {
        return iditems1;
    }

    public void setIditems1(Long iditems1) {
        this.iditems1 = iditems1;
    }

    public Long getIditems2() {
        return iditems2;
    }

    public void setIditems2(Long iditems2) {
        this.iditems2 = iditems2;
    }

    public Long getIditems3() {
        return iditems3;
    }

    public void setIditems3(Long iditems3) {
        this.iditems3 = iditems3;
    }

    public Long getIditems4() {
        return iditems4;
    }

    public void setIditems4(Long iditems4) {
        this.iditems4 = iditems4;
    }

    public Long getIditems5() {
        return iditems5;
    }

    public void setIditems5(Long iditems5) {
        this.iditems5 = iditems5;
    }
}
