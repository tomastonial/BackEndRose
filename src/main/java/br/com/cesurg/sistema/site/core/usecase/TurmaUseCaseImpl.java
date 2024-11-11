package br.com.cesurg.sistema.site.core.usecase;

import br.com.cesurg.sistema.site.core.domain.contract.TurmaRepository;
import br.com.cesurg.sistema.site.core.domain.contract.TurmaUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaUseCaseImpl implements TurmaUseCase {

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public void insert(Turma turma) {
        turmaRepository.insert(turma);
    }

    @Override
    public void update(int id, Turma turma) {
        turmaRepository.update(id,turma);
    }

    @Override
    public void delete(int id) {
        turmaRepository.delete(id);
    }

    @Override
    public List<Turma> fetch() {
        return turmaRepository.fetch();
    }

    @Override
    public Turma get(int id) {
        return turmaRepository.get(id);
    }
}
