package br.com.cesurg.sistema.site.core.domain.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "turma")
public class Turma {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;


    @Column(name = "qtd_alunos")
    private int quantidadeAluno;

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


    public int getQuantidadeAluno() {
        return quantidadeAluno;
    }

    public void setQuantidadeAluno(int quantidadeAluno) {
        this.quantidadeAluno = quantidadeAluno;
    }
}
