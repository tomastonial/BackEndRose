package br.com.cesurg.sistema.site.infra.repository.database;
import br.com.cesurg.sistema.site.core.domain.contract.TurmaRepository;
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
                INSERT INTO turma (nome, id_curso, quantidadeAluno)
                VALUES (:nome, :idCurso, :quantidadeAluno);
                """;
        entityManager.createNativeQuery(query, Turma.class)
                .setParameter("nome", turma.getNome())
                .setParameter("idCurso", turma.getIdCurso())
                .setParameter("quantidadeAluno", turma.getQuantidadeAluno())
                .executeUpdate();
    }

    @Transactional
    public void update(int id, Turma turma) {
        var query = """
                UPDATE turma SET 
                nome = :nome, id_curso = :idCurso, quantidadeAluno = :quantidadeAluno
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Turma.class)
                .setParameter("nome", turma.getNome())
                .setParameter("idCurso", turma.getIdCurso())
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
}
