package ru.bellintegrator.practice.service.office;

import ru.bellintegrator.practice.view.office.OfficeFilterViewIn;
import ru.bellintegrator.practice.view.office.OfficeFilterViewOut;
import ru.bellintegrator.practice.view.office.OfficeView;
import ru.bellintegrator.practice.view.office.OfficeViewSave;
import ru.bellintegrator.practice.view.office.OfficeViewUpdate;

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
