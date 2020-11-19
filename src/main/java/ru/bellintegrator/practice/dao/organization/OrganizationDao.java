package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.Person;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {

    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> all();

    /**
     * Получить объекты Organization по фильтру
     *
     * @param (name, inn, isActive)
     * @return
     */
    List<Organization> allByFilter(String name, String inn, boolean isActive);

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Long id);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);

    /**
     * Изменить Organization
     *
     * @param organization
     */
    void update(Organization organization);
}
