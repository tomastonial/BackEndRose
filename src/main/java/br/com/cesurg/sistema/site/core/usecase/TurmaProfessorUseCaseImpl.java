package br.com.cesurg.sistema.site.core.usecase;

import br.com.cesurg.sistema.site.core.domain.contract.TurmaProfessor.TurmaProfessorRepository;
import br.com.cesurg.sistema.site.core.domain.contract.TurmaProfessor.TurmaProfessorUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.TurmaProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaProfessorUseCaseImpl implements TurmaProfessorUseCase {

    @Autowired
    private TurmaProfessorRepository turmaProfessorRepository;


    @Override
    public void insert(TurmaProfessor turmaProfessor) {
        turmaProfessorRepository.insert(turmaProfessor);
    }

    @Override
    public List<TurmaProfessor> fetch() {
        return turmaProfessorRepository.fetch();
    }

    @Override
    public void delete(int id) {
        turmaProfessorRepository.delete(id);
    }
}
