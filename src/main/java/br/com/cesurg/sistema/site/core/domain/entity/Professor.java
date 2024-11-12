package br.com.cesurg.sistema.site.core.domain.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity(name = "professor")
public class Professor {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
