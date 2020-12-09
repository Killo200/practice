package ru.bellintegrator.practice.dao.office;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.view.office.OfficeFilterViewIn;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao{

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> getOfficeByFilter(OfficeFilterViewIn officeFilterViewIn) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);

        Root<Office> office = criteriaQuery.from(Office.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(office.get("organizationId"), officeFilterViewIn.organizationId));

        if (officeFilterViewIn.name != null) {
            predicates.add(criteriaBuilder.equal(office.get("name"), officeFilterViewIn.name));
        }

        if (officeFilterViewIn.phone != null) {
            predicates.add(criteriaBuilder.equal(office.get("phone"), officeFilterViewIn.phone));
        }

        if (officeFilterViewIn.isActive) {
            predicates.add(criteriaBuilder.equal(office.get("isActive"), officeFilterViewIn.isActive));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(criteriaQuery).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office getOfficeById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public void saveOffice(Office office) {
        em.persist(office);
    }

    @Override
    public void updateOffice(Office office) {
        em.merge(office);
    }
}
