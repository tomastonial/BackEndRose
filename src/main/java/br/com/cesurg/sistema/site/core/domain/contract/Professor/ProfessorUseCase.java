package br.com.cesurg.sistema.site.core.domain.contract.Professor;

import br.com.cesurg.sistema.site.core.domain.entity.Materia;
import br.com.cesurg.sistema.site.core.domain.entity.Professor;

import java.util.List;

public interface ProfessorUseCase {
    public void insert (Professor professor);
    public void update (int id, Professor professor);
    public void delete (int id);
    public List<Professor> fetch();
    public Professor get (int id);
    public List<Materia> materiasCompativeis(int id);
}
