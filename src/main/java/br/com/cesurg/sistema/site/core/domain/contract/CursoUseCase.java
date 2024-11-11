package br.com.cesurg.sistema.site.core.domain.contract;

import br.com.cesurg.sistema.site.core.domain.entity.Curso;

import java.util.List;

public interface CursoUseCase {
    public void insert (Curso curso);
    public void update (int id, Curso curso);
    public void delete (int id);
    public List<Curso> fetch();
    public Curso get (int id);
}
