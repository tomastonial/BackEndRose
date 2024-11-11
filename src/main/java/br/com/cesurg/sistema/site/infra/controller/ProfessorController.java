package br.com.cesurg.sistema.site.infra.controller;

import br.com.cesurg.sistema.site.core.domain.contract.ProfessorUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProfessorController {

    @Autowired
    private ProfessorUseCase professorUseCase;

    @PostMapping("/professor")
    public void insert(@RequestBody Professor professor) {
        professorUseCase.insert(professor);
    }

    @GetMapping("/professor")
    public List<Professor> fetch() {
        return professorUseCase.fetch();
    }

    @PostMapping("/professor/{id}")
    public void update(@PathVariable int id, @RequestBody Professor professor) {
        professorUseCase.update(id, professor);
    }

    @DeleteMapping("/professor/{id}")
    public void delete(@PathVariable int id) {
        professorUseCase.delete(id);
    }

    @GetMapping("/professor/{id}")
    public void get(@PathVariable int id) {
        professorUseCase.get(id);
    }
}