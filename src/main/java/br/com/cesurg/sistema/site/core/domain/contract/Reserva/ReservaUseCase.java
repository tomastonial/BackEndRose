package br.com.cesurg.sistema.site.core.domain.contract.Reserva;

import br.com.cesurg.sistema.site.core.domain.entity.Reserva;

import java.util.List;

public interface ReservaUseCase {
    public void insert(Reserva reserva);

    public List<Reserva> fetch();

    public void limpar();

    public void limparUm(int id);
}
