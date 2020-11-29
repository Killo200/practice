package ru.bellintegrator.practice.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewIn;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewOut;
import ru.bellintegrator.practice.view.organization.OrganizationView;
import ru.bellintegrator.practice.view.organization.OrganizationViewSave;
import ru.bellintegrator.practice.view.organization.OrganizationViewUpdate;

import java.util.List;

/**
 * Сервис организации
 */
@Validated
public interface OrganizationService {

    /**
     * Получение списка организаций, подходящих по фильтру
     *
     * @param organizationFilterViewIn
     * @return
     */
    List<OrganizationFilterViewOut> getOrganizationsByFilter(OrganizationFilterViewIn organizationFilterViewIn);

    /**
     * Получение организации по ID
     *
     * @param id
     * @return
     */
    OrganizationView getOrganizationById(Long id);

    /**
     * Обновление данных организации
     *
     * @param organizationViewUpdate
     */
    void updateOrganization(OrganizationViewUpdate organizationViewUpdate);

    /**
     * Добавление новой организации
     *
     * @param organizationViewSave
     */
    void saveOrganization(OrganizationViewSave organizationViewSave);
}
