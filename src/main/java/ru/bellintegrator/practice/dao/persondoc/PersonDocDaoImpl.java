package ru.bellintegrator.practice.dao.persondoc;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Document;

import javax.persistence.EntityManager;

/**
 * {@inheritDoc}
 */
@Repository
public class PersonDocDaoImpl implements PersonDocDao {

    private final EntityManager em;

    public PersonDocDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Document getDocumentById(Long id) {
        return em.find(Document.class, id);
    }
}
