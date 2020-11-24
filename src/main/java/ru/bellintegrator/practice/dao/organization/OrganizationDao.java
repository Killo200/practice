package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewIn;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewOut;

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
     * @param organizationFilterViewIn
     * @return
     */
    List<Organization> allByFilter(OrganizationFilterViewIn organizationFilterViewIn);

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
