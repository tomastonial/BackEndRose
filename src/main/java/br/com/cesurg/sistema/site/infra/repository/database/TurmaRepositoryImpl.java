package br.com.cesurg.sistema.site.infra.repository.database;
import br.com.cesurg.sistema.site.core.domain.contract.Turma.TurmaRepository;
import br.com.cesurg.sistema.site.core.domain.entity.Professor;
import br.com.cesurg.sistema.site.core.domain.entity.Turma;
import org.springframework.stereotype.Repository;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class TurmaRepositoryImpl implements TurmaRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insert(Turma turma) {
        var query = """
                INSERT INTO turma (nome, qtd_alunos)
                VALUES (:nome, :quantidadeAluno);
                """;
        entityManager.createNativeQuery(query, Turma.class)
                .setParameter("nome", turma.getNome())
                .setParameter("quantidadeAluno", turma.getQuantidadeAluno())
                .executeUpdate();
    }

    @Transactional
    public void update(int id, Turma turma) {
        var query = """
                UPDATE turma SET 
                nome = :nome, qtd_alunos = :quantidadeAluno
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Turma.class)
                .setParameter("nome", turma.getNome())
                .setParameter("id", id)
                .setParameter("quantidadeAluno", turma.getQuantidadeAluno())
                .executeUpdate();
    }

    @Transactional
    public void delete(int id) {
        var query = "DELETE FROM turma WHERE id = :id";
        entityManager.createNativeQuery(query).setParameter("id", id).executeUpdate();
    }

    public List<Turma> fetch() {
        var query = "SELECT * FROM turma;";
        return entityManager.createNativeQuery(query, Turma.class).getResultList();
    }

    public Turma get(int id) {
        var query = "SELECT * FROM turma WHERE id = :id;";
        return (Turma) entityManager.createNativeQuery(query, Turma.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Professor> professoresCompativeis(int id) {
        var query = """
                SELECT p.* 
                FROM professor p
                JOIN turma_professor tp ON tp.id_professor = p.id
                WHERE tp.id_turma = :idTurma;
                """;

        return entityManager.createNativeQuery(query, Professor.class)
                .setParameter("idTurma", id)
                .getResultList();
    }
}
