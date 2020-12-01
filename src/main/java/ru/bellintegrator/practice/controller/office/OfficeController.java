package ru.bellintegrator.practice.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.office.OfficeService;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер обработки запросов к офисам
 * */
@Api(value = "OfficeController", description = "Управление информацией об офисах")
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Запрос на получение списка офисов, подходящих по фильтру
     * */
    @ApiOperation(value = "Получить список офисов, подходящих по фильтру", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public List<OfficeFilterViewIn> getOfficeByFilter(@Valid @ResponseBody OfficeFilterViewIn officeFilterViewIn) {
        return OfficeService.getOfficeByFilter(officeFilterViewIn);
    }

    /**
     * Запрос на получение офиса по ID
     * */
    @ApiOperation(value = "Получить офис по ID", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public OfficeView getOfficeById(@Valid @PathVariable Long id) {
        return OfficeService.getOfficeById(id);
    }

    /**
     * Запрос на обновление данных офиса
     * */
    @ApiOperation(value = "Обновить данные по офису", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updateOffice(@Valid @ResponseBody OfficeViewUpdate officeViewUpdate) {
        officeService.updateOffice(officeViewUpdate);
    }

    /**
     * Запрос на добавление нового офиса
     * */
    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void saveOffice(@Valid @ResponseBody OfficeViewSave officeViewSave) {
        return officeService.saveOffice(officeViewSave);
    }
}
`