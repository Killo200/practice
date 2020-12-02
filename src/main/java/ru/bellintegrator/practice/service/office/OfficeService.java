package ru.bellintegrator.practice.service.office;

import ru.bellintegrator.practice.view.office.*;
import ru.bellintegrator.practice.view.organization.*;

import java.util.List;

/**
 * Сервис офиса
 */
public interface OfficeService {

    /**
     * Получение списка офисов, подходящих по фильтру
     *
     * @param officeFilterViewIn
     * @return
     */
    List<OfficeFilterViewOut> getOfficeByFilter(OfficeFilterViewIn officeFilterViewIn);

    /**
     * Получение офиса по ID
     *
     * @param id
     * @return
     */
    OfficeView getOfficeById(Long id);

    /**
     * Обновление данных офиса
     *
     * @param officeViewUpdate
     */
    void updateOffice(OfficeViewUpdate officeViewUpdate);

    /**
     * Добавление нового офиса
     *
     * @param officeViewSave
     */
    void saveOffice(OfficeViewSave officeViewSave);
}
