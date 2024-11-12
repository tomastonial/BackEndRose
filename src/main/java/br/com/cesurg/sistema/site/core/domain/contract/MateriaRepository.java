package br.com.cesurg.sistema.site.core.domain.contract;

import br.com.cesurg.sistema.site.core.domain.entity.Materia;

import java.util.List;

public interface MateriaRepository {
    public List<Materia> fetch();

    public void insert(Materia materia);
}
