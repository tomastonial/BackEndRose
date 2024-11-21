package br.com.cesurg.sistema.site.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "reserva")
public class Reserva {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_materia")
    private int id_materia;

    @Column(name = "id_sala")
    private int id_sala;

    @Column(name = "id_professor")
    private int id_professor;

    @Column(name = "id_turma")
    private int id_turma;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public Reserva(int id, int id_materia, int id_sala, int id_professor, int id_turma) {
        this.id = id;
        this.id_materia = id_materia;
        this.id_sala = id_sala;
        this.id_professor = id_professor;
        this.id_turma = id_turma;
    }
}
