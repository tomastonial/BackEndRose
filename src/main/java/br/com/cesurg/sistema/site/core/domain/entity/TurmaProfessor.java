package br.com.cesurg.sistema.site.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "turma_professor")
public class TurmaProfessor {
    @Id
    @Column(name = "id")
    private int id;

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
}
