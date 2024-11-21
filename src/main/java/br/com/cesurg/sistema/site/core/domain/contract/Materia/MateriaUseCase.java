package br.com.cesurg.sistema.site.core.domain.contract.Materia;

import br.com.cesurg.sistema.site.core.domain.entity.Materia;

import java.util.List;

public interface MateriaUseCase {
    public List<Materia> fetch();

    public void insert(Materia materia);

    public void deletar(int id);
}
