package br.com.cesurg.sistema.site.core.usecase;

import br.com.cesurg.sistema.site.core.domain.contract.Reserva.ReservaRepository;
import br.com.cesurg.sistema.site.core.domain.contract.Reserva.ReservaUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaUseCaseImpl implements ReservaUseCase {
    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void insert(Reserva reserva) {
        reservaRepository.insert(reserva);
    }

    @Override
    public List<Reserva> fetch() {
        return reservaRepository.fetch();
    }

    @Override
    public void limpar() {
        reservaRepository.limpar();
    }

    @Override
    public void limparUm(int id) {
        reservaRepository.limparUm(id);

    }
}
