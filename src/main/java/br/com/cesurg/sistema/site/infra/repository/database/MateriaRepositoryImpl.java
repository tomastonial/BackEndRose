package br.com.cesurg.sistema.site.infra.repository.database;

import br.com.cesurg.sistema.site.core.domain.contract.MateriaRepository;
import br.com.cesurg.sistema.site.core.domain.entity.Materia;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MateriaRepositoryImpl implements MateriaRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Materia> fetch() {
        var query = """
                SELECT * FROM materia
                """;

        return entityManager.createNativeQuery(query, Materia.class).getResultList();
    }

    @Transactional
    @Override
    public void insert(Materia materia) {
        var query = """
                INSERT INTO materia (nome, id_professor)
                VALUES(:nome, :id_professor);
                """;

        entityManager.createNativeQuery(query, Materia.class)
                .setParameter("nome", materia.getNome())
                .setParameter("id_professor", materia.getId_professor())
                .executeUpdate();
    }
}
