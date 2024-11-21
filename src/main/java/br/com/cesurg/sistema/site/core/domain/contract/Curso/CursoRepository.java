package br.com.cesurg.sistema.site.core.domain.contract.Curso;

import br.com.cesurg.sistema.site.core.domain.entity.Curso;

import java.util.List;

public interface CursoRepository {
    public void insert (Curso curso);
    public void update (int id, Curso curso);
    public void delete (int id);
    public List<Curso> fetch();
    public Curso get (int id);
}
