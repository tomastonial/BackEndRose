package br.com.cesurg.sistema.site.core.domain.contract.Ocupados;

import br.com.cesurg.sistema.site.core.domain.entity.Ocupados;

import java.util.List;

public interface OcupadosUseCase {
    public List<Ocupados> fetch();

    public void insert(Ocupados ocupados);

    public void delete(int id);

    public List<Ocupados> fetchNames();
}
