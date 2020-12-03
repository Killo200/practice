package ru.bellintegrator.practice.dao.country;

import ru.bellintegrator.practice.model.Country;
import ru.bellintegrator.practice.model.Office;

import java.util.List;

/**
 * DAO для работы со странами
 */
public interface CountryDao {

    /**
     * Получение списка кодов стран (гражданства)
     */
    List<Country> getCountries();
}
