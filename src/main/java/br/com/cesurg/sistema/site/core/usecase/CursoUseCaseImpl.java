package br.com.cesurg.sistema.site.core.usecase;

import br.com.cesurg.sistema.site.core.domain.contract.Curso.CursoRepository;
import br.com.cesurg.sistema.site.core.domain.contract.Curso.CursoUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoUseCaseImpl implements CursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void insert (Curso curso){
        cursoRepository.insert(curso);
    }

    @Override
    public void update(int id, Curso curso) {
        cursoRepository.update(id, curso);
    }

    @Override
    public void delete(int id) {
        cursoRepository.delete(id);
    }

    @Override
    public List<Curso> fetch() {
        return cursoRepository.fetch();
    }

    @Override
    public Curso get(int id) {
        return cursoRepository.get(id);
    }

}
