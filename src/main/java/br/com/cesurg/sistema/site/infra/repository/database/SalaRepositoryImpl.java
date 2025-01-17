package br.com.cesurg.sistema.site.infra.repository.database;

import br.com.cesurg.sistema.site.core.domain.contract.SalaRepository;
import br.com.cesurg.sistema.site.core.domain.entity.Reserva;
import br.com.cesurg.sistema.site.core.domain.entity.Sala;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaRepositoryImpl implements SalaRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insert(Sala sala) {
        var query = """
                INSERT INTO sala (nome, capacidade, localidade)
                VALUES (:nome, :capacidade, :localidade);
                """;
        entityManager.createNativeQuery(query, Sala.class)
                .setParameter("nome", sala.getNome())
                .setParameter("capacidade", sala.getCapacidade())
                .setParameter("localidade", sala.getLocalidade())
                .executeUpdate();
    }

    @Transactional
    public void update(int id, Sala sala) {
        var query = """
                UPDATE sala SET 
                nome = :nome, capacidade = :capacidade, localidade = :localidade
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Sala.class)
                .setParameter("nome", sala.getNome())
                .setParameter("capacidade", sala.getCapacidade())
                .setParameter("localidade", sala.getLocalidade())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void delete(int id) {
        var query = "DELETE FROM sala WHERE id = :id";
        entityManager.createNativeQuery(query).setParameter("id", id).executeUpdate();
    }

    public List<Sala> fetch() {
        var query = "SELECT * FROM sala;";
        return entityManager.createNativeQuery(query, Sala.class).getResultList();
    }

    public Sala get(int id) {
        var query = "SELECT * FROM sala WHERE id = :id;";
        return (Sala) entityManager.createNativeQuery(query, Sala.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public void save(Reserva reserva) {
        var query = """
                INSERT INTO reserva (id_turma, id_sala, id_professor)
                VALUES (:idTurma, :idSala, :idProfessor);
                """;
        entityManager.createNativeQuery(query)
                .setParameter("idTurma", reserva.getIdTurma())
                .setParameter("idSala", reserva.getIdSala())
                .setParameter("idProfessor", reserva.getIdProfessor())
                .executeUpdate();
    }


}
