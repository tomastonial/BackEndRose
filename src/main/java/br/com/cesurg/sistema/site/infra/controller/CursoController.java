package br.com.cesurg.sistema.site.infra.controller;

import br.com.cesurg.sistema.site.core.domain.contract.Curso.CursoUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CursoController {

    @Autowired
    private CursoUseCase cursoUseCase;

    @PostMapping("/curso")
    public void insert(@RequestBody Curso curso) {
        cursoUseCase.insert(curso);
    }

    @GetMapping("/curso")
    public List<Curso> fetch() {
        return cursoUseCase.fetch();
    }

    @PostMapping("/curso/{id}")
    public void update(@PathVariable int id, @RequestBody Curso curso) {
        cursoUseCase.update(id, curso);
    }

    @DeleteMapping("/curso/{id}")
    public void delete(@PathVariable int id) {
        cursoUseCase.delete(id);
    }

    @GetMapping("/curso/{id}")
    public void get(@PathVariable int id) {
        cursoUseCase.get(id);
    }
}