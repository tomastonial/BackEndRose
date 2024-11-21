package br.com.cesurg.sistema.site.infra.repository.database;
import br.com.cesurg.sistema.site.core.domain.contract.Professor.ProfessorRepository;
import br.com.cesurg.sistema.site.core.dto.ProfessorOutputMaterias;
import br.com.cesurg.sistema.site.core.domain.entity.Materia;
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
                INSERT INTO professor (nome)
                VALUES (:nome);
                """;
        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("nome", professor.getNome())
                .executeUpdate();
    }

    @Transactional
    public void update(int id, Professor professor) {
        var query = """
                UPDATE professor SET nome = :nome
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("nome", professor.getNome())
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

    @Override
    public List<Materia> materiasCompativeis(int id) {
        var query = """
                SELECT 
                m.id, 
                p.nome as nome_professor, 
                m.nome as nome_materia 
                FROM materia m 
                INNER JOIN professor p ON p.id = m.id_professor
                WHERE id_professor = :id;
                """;

        return entityManager.createNativeQuery(query, ProfessorOutputMaterias.class)
                .setParameter("id",id)
                .getResultList();
    }
}
