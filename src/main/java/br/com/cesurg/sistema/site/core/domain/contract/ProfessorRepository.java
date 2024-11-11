package br.com.cesurg.sistema.site.core.domain.contract;

import br.com.cesurg.sistema.site.core.domain.entity.Professor;

import java.util.List;

public interface ProfessorRepository {
    public void insert (Professor professor);
    public void update (int id, Professor professor);
    public void delete (int id);
    public List<Professor> fetch();
    public Professor get (int id);
}
