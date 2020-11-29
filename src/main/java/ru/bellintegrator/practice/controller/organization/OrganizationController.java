package ru.bellintegrator.practice.controller.organization;

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
import ru.bellintegrator.practice.service.organization.OrganizationService;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewIn;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewOut;
import ru.bellintegrator.practice.view.organization.OrganizationView;
import ru.bellintegrator.practice.view.organization.OrganizationViewSave;
import ru.bellintegrator.practice.view.organization.OrganizationViewUpdate;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер обработки запросов к организациям
 * */
@Api(value = "OrganizationController", description = "Управление информацией об организациях")
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController (OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Запрос на получение списка организаций, подходящих по фильтру
     * */
    @ApiOperation(value = "Получить список организаций, подходящих по фильтру", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public List<OrganizationFilterViewOut> getOrganizationsByFilter(@Valid @RequestBody OrganizationFilterViewIn organizationFilterViewIn) {
        return organizationService.getOrganizationsByFilter(organizationFilterViewIn);
    }

    /**
     * Запрос на получение организации по ID
     * */
    @ApiOperation(value = "Получить организацию по ID", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public OrganizationView getOrganizationById(@Valid @PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

    /**
     * Запрос на обновление данных организации
     * */
    @ApiOperation(value = "Обновить данные по организации", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updateOrganization(@Valid @RequestBody OrganizationViewUpdate organizationViewUpdate) {
        organizationService.updateOrganization(organizationViewUpdate);
    }

    /**
     * Запрос на добавление новой организации
     * */
    @ApiOperation(value = "Добавить новую организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void saveOrganization(@Valid @RequestBody OrganizationViewSave organizationViewSave) {
        organizationService.saveOrganization(organizationViewSave);
    }

}
