package br.com.cesurg.sistema.site.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "ocupados")
public class Ocupados {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_reserva")
    private int id_reserva;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }
}
