package ru.bellintegrator.practice.controller.country;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.country.CountryService;
import ru.bellintegrator.practice.view.country.CountryView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер обработки запросов к кодам стран(гражданство)
 * */

@Api(value = "CountryController", description = "Управление информацией о кодах стран(гражданство)")
@RestController
@RequestMapping(value = "/api/countries", produces = APPLICATION_JSON_VALUE)
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
    * Запрос на получение кодов стран (гражданство)
    */

    @ApiOperation(value = "Получить все типы кодов стран (гражданства)", httpMethod = "GET")
    @GetMapping
    public List<CountryView> getCountries () {
        return countryService.getCountries();
    }
}
