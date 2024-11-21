package br.com.cesurg.sistema.site.infra.repository.database;

import br.com.cesurg.sistema.site.core.domain.contract.Ocupados.OcupadosRepository;
import br.com.cesurg.sistema.site.core.dto.OcupadosNomeOutput;
import br.com.cesurg.sistema.site.core.dto.OcupadosOutput;
import br.com.cesurg.sistema.site.core.domain.entity.Ocupados;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OcupadosRepositoryImpl implements OcupadosRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Ocupados> fetch() {
        var query = """
                SELECT o.id, r.id_sala, r.id_turma, r.id_professor, r.id_materia FROM ocupados o
                INNER JOIN reserva r ON r.id = o.id_reserva;
                """;

        return entityManager.createNativeQuery(query, OcupadosOutput.class).getResultList();
    }

    @Transactional
    @Override
    public void insert(Ocupados ocupados) {
        var query = """
                INSERT INTO ocupados (id_reserva)
                VALUES(:id_reserva);
                """;
        entityManager.createNativeQuery(query, Ocupados.class)
                .setParameter("id_reserva", ocupados.getId_reserva())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = """
                DELETE FROM ocupados WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Ocupados.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Ocupados> fetchNames() {
        var query = """
                SELECT o.id as id,
                s.nome as sala,
                t.nome as turma,
                p.nome as professor,
                m.nome as materia
                FROM ocupados o
                INNER JOIN reserva r ON r.id = o.id_reserva
                LEFT JOIN sala s ON s.id = r.id_sala
                LEFT JOIN turma t ON t.id = r.id_turma
                LEFT JOIN professor p ON p.id = r.id_professor
                LEFT JOIN materia m ON m.id = r.id_materia
                """;

        return entityManager.createNativeQuery(query, OcupadosNomeOutput.class).getResultList();
    }
}
