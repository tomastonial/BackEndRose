package br.com.cesurg.sistema.site.infra.controller;

import br.com.cesurg.sistema.site.core.domain.contract.MateriaRepository;
import br.com.cesurg.sistema.site.core.domain.contract.MateriaUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MateriaController {
    @Autowired
    private MateriaUseCase materiaUseCase;

    @GetMapping("/materia")
    public List<Materia> fetch(){
        return materiaUseCase.fetch();
    }

    @PostMapping("/materia")
    public void insert(@RequestBody Materia materia){
        materiaUseCase.insert(materia);
    }
}
