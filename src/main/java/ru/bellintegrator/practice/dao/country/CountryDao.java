package ru.bellintegrator.practice.dao.country;

import ru.bellintegrator.practice.model.Country;

import java.util.List;

/**
 * DAO для работы со странами
 */
public interface CountryDao {

    /**
     * Получение списка кодов стран (гражданства)
     */
    List<Country> getCountries();

    /**
     * Получение страны по коду
     */
    Country getCountryByCode(Integer code);
}
