package br.com.cesurg.sistema.site.infra.controller;

import br.com.cesurg.sistema.site.core.domain.contract.TurmaProfessor.TurmaProfessorUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.TurmaProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class TurmaProfessorController {
    @Autowired
    private TurmaProfessorUseCase turmaProfessorUseCase;

    @GetMapping("/turma-professor")
    public List<TurmaProfessor> fetch(){
        return turmaProfessorUseCase.fetch();
    }

    @PostMapping("/turma-professor")
    public void insert(@RequestBody TurmaProfessor turmaProfessor){
        turmaProfessorUseCase.insert(turmaProfessor);
    }

    @DeleteMapping("/turma-professor/{id}")
    public void delete(@PathVariable int id){
        turmaProfessorUseCase.delete(id);
    }
}
