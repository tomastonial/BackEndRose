package br.com.cesurg.sistema.site.core.domain.contract;

import br.com.cesurg.sistema.site.core.domain.entity.Reserva;
import br.com.cesurg.sistema.site.core.domain.entity.Sala;
import br.com.cesurg.sistema.site.core.domain.entity.Turma;

import java.util.List;

public interface SalaUseCase {
    public void insert (Sala sala);
    public void update (int id, Sala sala);
    public void delete (int id);
    public List<Sala> fetch();
    public Sala get (int id);
    public void save (Reserva reserva);
    public List<Turma> turmasCompativeis(int id);
}
