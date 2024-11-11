package br.com.cesurg.sistema.site.core.usecase;

import br.com.cesurg.sistema.site.core.domain.contract.ProfessorRepository;
import br.com.cesurg.sistema.site.core.domain.contract.ProfessorUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorUseCaseImpl implements ProfessorUseCase {
    @Autowired
    private ProfessorRepository professorRepository;
    @Override
    public void insert(Professor professor) {
        professorRepository.insert(professor);
    }

    @Override
    public void update(int id, Professor professor) {
        professorRepository.update(id,professor);
    }

    @Override
    public void delete(int id) {
        professorRepository.delete(id);
    }

    @Override
    public List<Professor> fetch() {
        return professorRepository.fetch();
    }

    @Override
    public Professor get(int id) {
        return professorRepository.get(id);
    }
}
