package br.com.cesurg.sistema.site.core.usecase;

import br.com.cesurg.sistema.site.core.domain.contract.MateriaRepository;
import br.com.cesurg.sistema.site.core.domain.contract.MateriaUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaUseCaseImpl implements MateriaUseCase {
    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<Materia> fetch() {
        return materiaRepository.fetch();
    }

    @Override
    public void insert(Materia materia) {
        materiaRepository.insert(materia);
    }
}
