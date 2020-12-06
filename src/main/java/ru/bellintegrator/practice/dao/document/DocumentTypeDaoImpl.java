package ru.bellintegrator.practice.dao.document;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentType getDocumentTypeById(Long id) {

        String queryString = "SELECT d FROM DocumentType d WHERE d.id = :id";
        TypedQuery<DocumentType> query = em.createQuery(queryString, DocumentType.class);
        query.setParameter("id", id);
        DocumentType documentType = query.getSingleResult();
        return documentType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentType getDocumentTypeByCode(Integer code) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> criteriaQuery = criteriaBuilder.createQuery(DocumentType.class);
        Root<DocumentType> doc = criteriaQuery.from(DocumentType.class);
        Predicate predicate = criteriaBuilder.equal(doc.get("code"),code);
        criteriaQuery.select(doc).where(predicate);
        TypedQuery<DocumentType> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentType getDocumentTypeByName(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> criteriaQuery = criteriaBuilder.createQuery(DocumentType.class);
        Root<DocumentType> doc = criteriaQuery.from(DocumentType.class);
        Predicate predicate = criteriaBuilder.equal(doc.get("name"),name);
        criteriaQuery.select(doc).where(predicate);
        TypedQuery<DocumentType> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
}
