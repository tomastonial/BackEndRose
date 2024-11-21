package br.com.cesurg.sistema.site.infra.repository.database;

import br.com.cesurg.sistema.site.core.domain.contract.TurmaProfessor.TurmaProfessorRepository;
import br.com.cesurg.sistema.site.core.dto.TurmaProfessorOutPut;
import br.com.cesurg.sistema.site.core.domain.entity.TurmaProfessor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurmaProfessorRepositoryImpl implements TurmaProfessorRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void insert(TurmaProfessor turmaProfessor) {
        var query = """
                INSERT INTO turma_professor (id_professor, id_turma)
                VALUES (:id_professor, :id_turma);
                """;

        entityManager.createNativeQuery(query, TurmaProfessor.class)
                .setParameter("id_professor", turmaProfessor.getId_professor())
                .setParameter("id_turma", turmaProfessor.getId_turma())
                .executeUpdate();
    }

    @Override
    public List<TurmaProfessor> fetch() {
        var query = """
                SELECT tp.id, t.nome, p.nome FROM turma_professor tp
                INNER JOIN turma t ON t.id = tp.id_turma
                INNER JOIN professor p ON p.id = tp.id_professor;
                """;

        return entityManager.createNativeQuery(query, TurmaProfessorOutPut.class).getResultList();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = """
                DELETE FROM turma_professor WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, TurmaProfessor.class)
                .setParameter("id", id)
                .executeUpdate();
    }
}
