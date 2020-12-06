package ru.bellintegrator.practice.service.person;

import ru.bellintegrator.practice.view.person.PersonFilterViewIn;
import ru.bellintegrator.practice.view.person.PersonFilterViewOut;
import ru.bellintegrator.practice.view.person.PersonView;
import ru.bellintegrator.practice.view.person.PersonViewSave;
import ru.bellintegrator.practice.view.person.PersonViewUpdate;

import java.util.List;

/**
 * Сервис человека
 */
public interface PersonService {

    /**
     * Получение списка людей, подходящих по фильтру
     *
     * @param personFilterViewIn
     * @return
     */
    List<PersonFilterViewOut> getPersonByFilter(PersonFilterViewIn personFilterViewIn);

    /**
     * Получение человека по ID
     *
     * @param id
     * @return
     */
    PersonView getPersonById(Long id);

    /**
     * Обновление данных человека
     *
     * @param personViewUpdate
     */
    void updatePerson(PersonViewUpdate personViewUpdate);

    /**
     * Добавление нового человека
     *
     * @param personViewSave
     */
    void savePerson(PersonViewSave personViewSave);
}
