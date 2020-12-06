package ru.bellintegrator.practice.dao.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Country;

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
public class CountryDaoImpl implements CountryDao {

    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Country> getCountries() {
        Query query = em.createNativeQuery("SELECT c.* FROM Country c", Country.class);

        List<Country> countries = query.getResultList();
        return countries;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Country getCountryByCode(Integer code) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteriaQuery = criteriaBuilder.createQuery(Country.class);

        Root<Country> country = criteriaQuery.from(Country.class);

        Predicate predicate = criteriaBuilder.equal(country.get("codeCountry"), code);
        criteriaQuery.select(country).where(predicate);
        TypedQuery<Country> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
}
