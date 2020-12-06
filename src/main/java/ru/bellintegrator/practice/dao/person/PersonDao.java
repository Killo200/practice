package ru.bellintegrator.practice.dao.person;

import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.view.person.PersonFilterViewIn;

import java.util.List;

/**
 * DAO для работы с Person
 */
public interface PersonDao {

    /**
     * Получение списка людей, подходящих по фильтру
     *
     * @param personFilterViewIn
     * @return
     */
    List<Person> getPersonByFilter(PersonFilterViewIn personFilterViewIn);

    /**
     * Получение человека по ID
     *
     * @param id
     * @return
     */
    Person getPersonById(Long id);

    /**
     * Обновление данных человека
     *
     * @param person
     */
    void updatePerson(Person person);

    /**
     * Добавление нового человека
     *
     * @param person
     */
    void savePerson(Person person);
}
