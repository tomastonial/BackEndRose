package br.com.cesurg.sistema.site.infra.controller;

import br.com.cesurg.sistema.site.core.domain.contract.Reserva.ReservaUseCase;
import br.com.cesurg.sistema.site.core.domain.entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ReservaController {
    @Autowired
    private ReservaUseCase reservaUseCase;

    @PostMapping("/reserva")
    public void insert(@RequestBody Reserva reserva){
        reservaUseCase.insert(reserva);
    }

    @GetMapping("/reserva")
    public List<Reserva> fetch(){
        return reservaUseCase.fetch();
    }

    @DeleteMapping("/reserva")
    public void limpar(){
        reservaUseCase.limpar();
    }

    @DeleteMapping("/reserva/{id}")
    public void limparUm(@PathVariable int id){
        reservaUseCase.limparUm(id);
    }
}
