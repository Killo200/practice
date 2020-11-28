package ru.bellintegrator.practice.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.organization.*;

import java.util.List;

/**
 * Сервис организации
 */
@Validated
public interface OrganizationService {

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
    List<OrganizationFilterViewOut> allByFilter(OrganizationFilterViewIn organizationFilterViewIn);

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    OrganizationView loadById(Long id);

    /**
     * Сохранить Organization
     *
     * @param organizationViewSave
     */
    void save(OrganizationViewSave organizationViewSave);

    /**
     * Изменить Organization
     *
     * @param organizationViewUpdate
     */
    void update(OrganizationViewUpdate organizationViewUpdate);
}
