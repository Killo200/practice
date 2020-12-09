package ru.bellintegrator.practice.controller.person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.person.PersonService;
import ru.bellintegrator.practice.view.person.PersonFilterViewIn;
import ru.bellintegrator.practice.view.person.PersonFilterViewOut;
import ru.bellintegrator.practice.view.person.PersonView;
import ru.bellintegrator.practice.view.person.PersonViewSave;
import ru.bellintegrator.practice.view.person.PersonViewUpdate;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер обработки запросов к людям
 * */

@Api(value = "PersonController", description = "Управление информацией о людях")
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Запрос на получение списка людей, подходящих по фильтру
     **/

    @ApiOperation(value = "Получить список людей, подходящих по фильтру", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public List<PersonFilterViewOut> getPersonByFilter(@Valid @RequestBody PersonFilterViewIn personFilterViewIn) {
        return personService.getPersonByFilter(personFilterViewIn);
    }

    /**
     * Запрос на получение человека по ID
     **/

    @ApiOperation(value = "Получить человека по ID", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public PersonView getPersonById(@Valid @PathVariable Long id) {
        return personService.getPersonById(id);
    }

    /**
     * Запрос на обновление данных человека
     **/

    @ApiOperation(value = "Обновить данные о человеке", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updatePerson(@Valid @RequestBody PersonViewUpdate personViewUpdate) {
        personService.updatePerson(personViewUpdate);
    }

    /**
     * Запрос на добавление нового человека
     **/

    @ApiOperation(value = "Добавить нового человека", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void savePerson(@Valid @RequestBody PersonViewSave personViewSave) {
        personService.savePerson(personViewSave);
    }
}
