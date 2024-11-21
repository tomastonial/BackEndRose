package br.com.cesurg.sistema.site.infra.repository.database;

import br.com.cesurg.sistema.site.core.domain.contract.Reserva.ReservaRepository;
import br.com.cesurg.sistema.site.core.dto.ReservaOutput;
import br.com.cesurg.sistema.site.core.domain.entity.Ocupados;
import br.com.cesurg.sistema.site.core.domain.entity.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaRepositoryImpl implements ReservaRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void insert(Reserva reserva) {

        var query = """
            INSERT INTO reserva (id_materia, id_sala, id_professor, id_turma)
            VALUES (:id_materia, :id_sala, :id_professor, :id_turma)
            RETURNING id;
            """;


        Integer idReserva = (Integer) entityManager.createNativeQuery(query)
                .setParameter("id_materia", reserva.getId_materia())
                .setParameter("id_sala", reserva.getId_sala())
                .setParameter("id_professor", reserva.getId_professor())
                .setParameter("id_turma", reserva.getId_turma())
                .getSingleResult();


        reserva.setId(idReserva);


        var query2 = """
            INSERT INTO ocupados (id_reserva)
            VALUES (:id_reserva);
            """;

        entityManager.createNativeQuery(query2)
                .setParameter("id_reserva", reserva.getId())
                .executeUpdate();
    }

    @Override
    public List<Reserva> fetch() {
        var query = """
                SELECT
                r.id, p.nome as Professor, s.nome as Sala, t.nome as Turma, m.nome as Materia
                FROM reserva r
                INNER JOIN professor p ON p.id = r.id_professor
                INNER JOIN sala s ON s.id = r.id_sala
                INNER JOIN turma t ON t.id = r.id_turma
                INNER JOIN materia m ON m.id = r.id_materia;
                """;
        return entityManager.createNativeQuery(query, ReservaOutput.class).getResultList();
    }

    @Transactional
    @Override
    public void limpar() {
        var query = """
                DELETE FROM reserva;
                """;

        entityManager.createNativeQuery(query, Reserva.class).executeUpdate();
    }

    @Transactional
    @Override
    public void limparUm(int id) {
        var query = """
                DELETE FROM reserva WHERE id = :id;
                """;

        var query2 = """
                DELETE FROM ocupados WHERE id_reserva = :id;
                """;

        entityManager.createNativeQuery(query2, Ocupados.class).setParameter("id", id).executeUpdate();
        entityManager.createNativeQuery(query, Reserva.class).setParameter("id", id).executeUpdate();

    }
}
