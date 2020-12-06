package ru.bellintegrator.practice.dao.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dao.country.CountryDaoImpl;
import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.view.person.PersonFilterViewIn;

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
public class PersonDaoImpl implements PersonDao {

    private final EntityManager em;
    private final CountryDaoImpl countryDao;

    @Autowired
    public PersonDaoImpl(EntityManager em, CountryDaoImpl countryDao) {
        this.em = em;
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> getPersonByFilter(PersonFilterViewIn personFilterViewIn) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> people = criteriaQuery.from(Person.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(people.get("office"),personFilterViewIn.officeId));
        if (personFilterViewIn.firstName !=null) {
            predicates.add(criteriaBuilder.equal(people.get("firstName"), personFilterViewIn.firstName));
        }
        if (personFilterViewIn.secondName != null) {
            predicates.add(criteriaBuilder.equal(people.get("secondName"), personFilterViewIn.secondName));
        }
        if (personFilterViewIn.middleName != null) {
            predicates.add(criteriaBuilder.equal(people.get("middleName"), personFilterViewIn.middleName));
        }
        if (personFilterViewIn.position != null) {
            predicates.add(criteriaBuilder.equal(people.get("position"), personFilterViewIn.position));
        }
        if (personFilterViewIn.docCode != null) {
            predicates.add(criteriaBuilder.equal(people.get("document").get("documentType").get("code"), personFilterViewIn.docCode));
        }
        if (personFilterViewIn.citizenshipCode != null) {
            predicates.add(criteriaBuilder.equal(people.get("country"), countryDao.getCountryByCode(personFilterViewIn.citizenshipCode)));
        }
        criteriaQuery.select(people).where(predicates.toArray(new Predicate[] {}));
        TypedQuery<Person> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getPersonById(Long id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> employeeRoot = criteriaQuery.from(Person.class);
        criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("id"),
                criteriaBuilder.parameter(Long.class, "id")));
        TypedQuery<Person> typedQuery = em.createQuery(criteriaQuery);
        typedQuery.setParameter("id", id);

        return typedQuery.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePerson(Person person) {
        em.merge(person);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void savePerson(Person person) {
        em.persist(person);
    }
}
