package br.com.cesurg.sistema.site.infra.repository.database;
import br.com.cesurg.sistema.site.core.domain.contract.ProfessorRepository;
import br.com.cesurg.sistema.site.core.domain.entity.Professor;
import org.springframework.stereotype.Repository;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insert(Professor professor) {
        var query = """
                INSERT INTO professor (nome, departamento, especializacao)
                VALUES (:nome, :departamento, :especializacao);
                """;
        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("nome", professor.getNome())
                .setParameter("departamento", professor.getDepartamento())
                .setParameter("especializacao", professor.getEspecializacao())
                .executeUpdate();
    }

    @Transactional
    public void update(int id, Professor professor) {
        var query = """
                UPDATE professor SET 
                nome = :nome, departamento = :departamento, especializacao = :especializacao
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("nome", professor.getNome())
                .setParameter("departamento", professor.getDepartamento())
                .setParameter("especializacao", professor.getEspecializacao())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void delete(int id) {
        var query = "DELETE FROM professor WHERE id = :id";
        entityManager.createNativeQuery(query).setParameter("id", id).executeUpdate();
    }

    public List<Professor> fetch() {
        var query = "SELECT * FROM professor;";
        return entityManager.createNativeQuery(query, Professor.class).getResultList();
    }

    public Professor get(int id) {
        var query = "SELECT * FROM professor WHERE id = :id;";
        return (Professor) entityManager.createNativeQuery(query, Professor.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
