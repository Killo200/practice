package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewIn;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {

    /**
     * Получить объекты Organization по фильтру
     *
     * @param organizationFilterViewIn
     * @return
     */
    List<Organization> getOrganizationsByFilter(OrganizationFilterViewIn organizationFilterViewIn);

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization getOrganizationById(Long id);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void saveOrganization(Organization organization);

    /**
     * Изменить Organization
     *
     * @param organization
     */
    void updateOrganization(Organization organization);
}
