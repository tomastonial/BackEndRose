package br.com.cesurg.sistema.site.core.domain.contract.Turma;

import br.com.cesurg.sistema.site.core.domain.entity.Professor;
import br.com.cesurg.sistema.site.core.domain.entity.Turma;

import java.util.List;

public interface TurmaUseCase {
    public void insert (Turma turma);
    public void update (int id, Turma turma);
    public void delete (int id);
    public List<Turma> fetch();
    public Turma get (int id);
    public List<Professor> professoresCompativeis(int id);
}
