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

    @Column (name = "departamento")
    private String departamento;

    @Column(name = "especialização")
    private List<String> especializacao;

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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<String> getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(List<String> especializacao) {
        this.especializacao = especializacao;
    }
}
