package br.com.cesurg.sistema.site.core.domain.contract.TurmaProfessor;

import br.com.cesurg.sistema.site.core.domain.entity.TurmaProfessor;

import java.util.List;

public interface TurmaProfessorUseCase {

    public void insert(TurmaProfessor turmaProfessor);

    public List<TurmaProfessor> fetch();

    public void delete(int id);
}
