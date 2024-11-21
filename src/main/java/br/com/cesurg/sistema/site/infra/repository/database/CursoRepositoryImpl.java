package br.com.cesurg.sistema.site.infra.repository.database;
import br.com.cesurg.sistema.site.core.domain.contract.Curso.CursoRepository;
import br.com.cesurg.sistema.site.core.domain.entity.Curso;
import org.springframework.stereotype.Repository;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insert(Curso curso) {
        var query = """
                INSERT INTO curso (nome, duracao)
                VALUES (:nome, :duracao);
                """;
        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("nome", curso.getNome())
                .setParameter("duracao", curso.getDuracao())
                .executeUpdate();
    }

    @Transactional
    public void update(int id, Curso curso) {
        var query = """
                UPDATE curso SET 
                nome = :nome, duracao = :duracao
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("nome", curso.getNome())
                .setParameter("duracao", curso.getDuracao())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void delete(int id) {
        var query = "DELETE FROM curso WHERE id = :id";
        entityManager.createNativeQuery(query).setParameter("id", id).executeUpdate();
    }

    public List<Curso> fetch() {
        var query = "SELECT * FROM curso;";
        return entityManager.createNativeQuery(query, Curso.class).getResultList();
    }

    public Curso get(int id) {
        var query = "SELECT * FROM curso WHERE id = :id;";
        return (Curso) entityManager.createNativeQuery(query, Curso.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
