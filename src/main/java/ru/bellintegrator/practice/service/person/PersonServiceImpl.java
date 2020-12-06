package ru.bellintegrator.practice.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.country.CountryDao;
import ru.bellintegrator.practice.dao.document.DocumentTypeDao;
import ru.bellintegrator.practice.dao.office.OfficeDao;
import ru.bellintegrator.practice.dao.person.PersonDao;
import ru.bellintegrator.practice.dao.persondoc.PersonDocDao;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.DocumentType;
import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.utils.BadDataException;
import ru.bellintegrator.practice.view.person.PersonFilterViewIn;
import ru.bellintegrator.practice.view.person.PersonFilterViewOut;
import ru.bellintegrator.practice.view.person.PersonView;
import ru.bellintegrator.practice.view.person.PersonViewSave;
import ru.bellintegrator.practice.view.person.PersonViewUpdate;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private final OfficeDao officeDao;
    private final DocumentTypeDao documentTypeDao ;
    private final CountryDao countryDao;
    private final PersonDocDao personDocDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public PersonServiceImpl(PersonDao personDao, OfficeDao officeDao, DocumentTypeDao documentTypeDao, CountryDao countryDao, PersonDocDao personDocDao, MapperFacade mapperFacade) {
        this.personDao = personDao;
        this.officeDao = officeDao;
        this.documentTypeDao = documentTypeDao;
        this.countryDao = countryDao;
        this.personDocDao = personDocDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<PersonFilterViewOut> getPersonByFilter(PersonFilterViewIn personFilterViewIn) {
        List<Person> people = personDao.getPersonByFilter(personFilterViewIn);
        return mapperFacade.mapAsList(people, PersonFilterViewOut.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public PersonView getPersonById(Long id) {
        Person person = personDao.getPersonById(id);
        Document document = personDocDao.getDocumentById(id);

        if(person == null) {
            throw new BadDataException();
        }

        PersonView view = new PersonView();
        mapperFacade.map(person, view);
        if (person.getDocument() != null) {
            view.docName = document.getDocumentType().getName();
            view.documentNumber = document.getDocumentNumber();
            view.docDate = document.getDocumentDate();
        }
        if (person.getCountry() != null) {
            view.citizenshipName = person.getCountry().getName();
            view.citizenshipCode = person.getCountry().getCodeCountry();
        }
        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updatePerson(PersonViewUpdate personViewUpdate) {
        Person person = personDao.getPersonById(personViewUpdate.id);
        if (personViewUpdate.officeId != null) {
            person.setOffice(officeDao.getOfficeById(personViewUpdate.officeId));
        }
        mapperFacade.map(personViewUpdate, person);

        if (personViewUpdate.docName != null) {
            if (person.getDocument() != null) {
                person.getDocument().setDocumentNumber(personViewUpdate.documentNumber);
                person.getDocument().setDocumentDate(personViewUpdate.docDate);
            } else {
                Document document = new Document();
                DocumentType documentType;
                try {
                    documentType= documentTypeDao.getDocumentTypeByName(personViewUpdate.docName);
                    if (documentType != null) {
                        document.setDocumentType(documentType);
                        document.setDocumentNumber(personViewUpdate.documentNumber);
                        document.setDocumentDate(personViewUpdate.docDate);
                        document.setPerson(person);
                        person.setDocument(document);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Такое гражданство не существует");
                }
            }
        }
        if (personViewUpdate.citizenshipCode != null) {
            person.setCountry(countryDao.getCountryByCode(personViewUpdate.citizenshipCode));
        }
        personDao.updatePerson(person);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void savePerson(PersonViewSave personViewSave) {
        Person person = mapperFacade.map(personViewSave, Person.class);
        person.setOffice(officeDao.getOfficeById(personViewSave.officeId));
        Document document = new Document();
        if (personViewSave.docCode != null) {
            document.setPerson(person);
            DocumentType documentType = documentTypeDao.getDocumentTypeByCode(personViewSave.docCode);
            document.setDocumentType(documentType);
            document.setDocumentNumber(personViewSave.documentNumber);
            document.setDocumentDate(personViewSave.docDate);
            person.setDocument(document);
        } else if (personViewSave.docName != null) {
            DocumentType documentType = documentTypeDao.getDocumentTypeByName(personViewSave.docName);
            document.setPerson(person);
            document.setDocumentType(documentType);
            document.setDocumentNumber(personViewSave.documentNumber);
            document.setDocumentDate(personViewSave.docDate);
            person.setDocument(document);
        }
        if (personViewSave.citizenshipCode != null) {
            person.setCountry(countryDao.getCountryByCode(personViewSave.citizenshipCode));
        }
        personDao.savePerson(person);
    }
}
