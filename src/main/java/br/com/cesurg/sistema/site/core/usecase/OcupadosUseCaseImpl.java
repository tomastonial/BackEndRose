package br.com.cesurg.sistema.site.core.usecase;

import br.com.cesurg.sistema.site.core.domain.contract.Ocupados.OcupadosRepository;
import br.com.cesurg.sistema.site.core.domain.contract.Ocupados.OcupadosUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Ocupados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcupadosUseCaseImpl implements OcupadosUseCase {
    @Autowired
    private OcupadosRepository ocupadosRepository;

    @Override
    public List<Ocupados> fetch() {
        return ocupadosRepository.fetch();
    }

    @Override
    public void insert(Ocupados ocupados) {
        ocupadosRepository.insert(ocupados);
    }

    @Override
    public void delete(int id) {
        ocupadosRepository.delete(id);
    }

    @Override
    public List<Ocupados> fetchNames() {
        return ocupadosRepository.fetchNames();
    }
}
