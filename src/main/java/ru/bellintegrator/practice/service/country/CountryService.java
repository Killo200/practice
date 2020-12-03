package ru.bellintegrator.practice.service.country;

import ru.bellintegrator.practice.view.country.CountryView;

import java.util.List;

/**
 * Сервис стран
 */
public interface CountryService {

    /**
     * Получение списка кодов стран (гражданства)
     */
    List<CountryView> getCountries ();
}
