package br.com.cesurg.sistema.site.infra.controller;

import br.com.cesurg.sistema.site.core.domain.contract.SalaUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Reserva;
import br.com.cesurg.sistema.site.core.domain.entity.Sala;
import br.com.cesurg.sistema.site.core.domain.entity.Turma;
import br.com.cesurg.sistema.site.core.usecase.FiltroSalaUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SalaController {

    private final SalaUseCase salaUseCase;
    private final FiltroSalaUseCaseImpl filtroSalaUseCase;

    @Autowired
    public SalaController(SalaUseCase salaUseCase, FiltroSalaUseCaseImpl filtroSalaUseCase) {
        this.salaUseCase = salaUseCase;
        this.filtroSalaUseCase = filtroSalaUseCase;
    }

    @PostMapping("/sala")
    public void insert(@RequestBody Sala sala) {
        salaUseCase.insert(sala);
    }

    @GetMapping("/sala")
    public List<Sala> fetch() {
        return salaUseCase.fetch();
    }

    @PostMapping("/sala/{id}")
    public void update(@PathVariable int id, @RequestBody Sala sala) {
        salaUseCase.update(id, sala);
    }

    @DeleteMapping("/sala/{id}")
    public void delete(@PathVariable int id) {
        salaUseCase.delete(id);
    }

    @GetMapping("/sala/{id}")
    public Sala get(@PathVariable int id) {
        return salaUseCase.get(id);
    }

    @GetMapping("/sala/filtrar-compativeis")
    public List<Sala> filtrarSalasCompativeis(@RequestBody Turma turma) {
        return filtroSalaUseCase.filtrarSalasCompativeis(turma);
    }

    @PostMapping("/sala/save")
    public void save(@RequestBody Reserva reserva) {
        salaUseCase.save(reserva);
    }

}
