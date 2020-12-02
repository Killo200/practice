package ru.bellintegrator.practice.dao.office;

import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.office.OfficeFilterViewIn;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewIn;

import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {

    /**
     * Получить объекты Office по фильтру
     *
     * @param officeFilterViewIn
     * @return
     */
    List<Office> getOfficeByFilter(OfficeFilterViewIn officeFilterViewIn);

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    Office getOfficeById(Long id);

    /**
     * Сохранить Office
     *
     * @param office
     */
    void saveOffice(Office office);

    /**
     * Изменить Office
     *
     * @param office
     */
    void updateOffice(Office office);
}
