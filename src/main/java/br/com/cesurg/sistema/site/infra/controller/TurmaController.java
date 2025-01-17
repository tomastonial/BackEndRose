package br.com.cesurg.sistema.site.infra.controller;

import br.com.cesurg.sistema.site.core.domain.contract.TurmaUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TurmaController {

    @Autowired
    private TurmaUseCase turmaUseCase;

    @PostMapping("/turma")
    public void insert(@RequestBody Turma turma) {
        turmaUseCase.insert(turma);
    }

    @GetMapping("/turma")
    public List<Turma> fetch() {
        return turmaUseCase.fetch();
    }

    @PostMapping("/turma/{id}")
    public void update(@PathVariable int id, @RequestBody Turma turma) {
        turmaUseCase.update(id, turma);
    }

    @DeleteMapping("/turma{id}")
    public void delete(@PathVariable int id) {
        turmaUseCase.delete(id);
    }

    @GetMapping("/turma{id}")
    public void get(@PathVariable int id) {
        turmaUseCase.get(id);
    }
}