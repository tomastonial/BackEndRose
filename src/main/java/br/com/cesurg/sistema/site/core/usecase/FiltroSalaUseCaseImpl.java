package br.com.cesurg.sistema.site.core.usecase;

import br.com.cesurg.sistema.site.core.domain.entity.Sala;
import br.com.cesurg.sistema.site.core.domain.entity.Turma;
import br.com.cesurg.sistema.site.core.domain.contract.SalaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiltroSalaUseCaseImpl {

    private final SalaUseCase salaUseCase;

    @Autowired
    public FiltroSalaUseCaseImpl(SalaUseCase salaUseCase) {
        this.salaUseCase = salaUseCase;
    }

    public List<Sala> filtrarSalasCompativeis(Turma turma) {
        List<Sala> salas = salaUseCase.fetch();
        List<Sala> salasCompativeis = new ArrayList<>();

        for (Sala sala : salas) {
            if (sala.getCapacidade() >= turma.getQuantidadeAluno()) {
                salasCompativeis.add(sala);
            }
        }
        return salasCompativeis;
    }
}
