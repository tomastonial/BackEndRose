package br.com.cesurg.sistema.site.infra.controller;

import br.com.cesurg.sistema.site.core.domain.contract.Ocupados.OcupadosUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Ocupados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class OcupadosController {
    @Autowired
    private OcupadosUseCase ocupadosUseCase;

    @GetMapping("/ocupados")
    public List<Ocupados> fetch(){
        return ocupadosUseCase.fetch();
    }

    @PostMapping("/ocupados")
    public void insert(@RequestBody Ocupados ocupados){
        ocupadosUseCase.insert(ocupados);
    }

    @DeleteMapping("/ocupados")
    public void delete(@PathVariable int id){
        ocupadosUseCase.delete(id);
    }

    @GetMapping("/ocupados/nomes")
    public List<Ocupados> fetchNames(){
        return ocupadosUseCase.fetchNames();
    }
}
