package br.com.cesurg.sistema.site.core.usecase;

import br.com.cesurg.sistema.site.core.domain.contract.SalaRepository;
import br.com.cesurg.sistema.site.core.domain.contract.SalaUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Reserva;
import br.com.cesurg.sistema.site.core.domain.entity.Sala;
import br.com.cesurg.sistema.site.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaUseCaseImpl implements SalaUseCase {

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public void insert(Sala sala) {
        salaRepository.insert(sala);
    }

    @Override
    public void update(int id, Sala sala) {
        salaRepository.update(id,sala);
    }

    @Override
    public void delete(int id) {
        salaRepository.delete(id);
    }

    @Override
    public List<Sala> fetch() {
        return salaRepository.fetch();
    }

    @Override
    public Sala get(int id) {
        return salaRepository.get(id);
    }

    @Override
    public void save(Reserva reserva) {
        salaRepository.save(reserva);
    }

    @Override
    public List<Turma> turmasCompativeis(int id) {
        return salaRepository.turmasCompativeis(id);
    }
}
