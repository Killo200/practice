package ru.bellintegrator.practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewIn;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getOrganizationsByFilter(OrganizationFilterViewIn orgFilter) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);

        Root<Organization> organization = criteriaQuery.from(Organization.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(organization.get("name"), orgFilter.name));

        if (orgFilter.inn != null) {
            predicates.add(criteriaBuilder.equal(organization.get("inn"), orgFilter.inn));
        }

        if (orgFilter.isActive) {
            predicates.add(criteriaBuilder.equal(organization.get("isActive"), orgFilter.isActive));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(criteriaQuery).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getOrganizationById(Long id) {
        return em.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOrganization(Organization organization) {
        em.persist(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOrganization(Organization organization) {
        em.merge(organization);
    }
}
