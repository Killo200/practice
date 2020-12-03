package ru.bellintegrator.practice.dao.document;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {

    private final EntityManager em;

    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentType> getDocs() {
        Query query = em.createNativeQuery("SELECT d.* FROM Doc_Type d", DocumentType.class);

        List<DocumentType> documents = query.getResultList();
        return documents;
    }
}
