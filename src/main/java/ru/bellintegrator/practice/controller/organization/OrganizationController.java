package ru.bellintegrator.practice.controller.organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.service.organization.OrganizationService;
import ru.bellintegrator.practice.view.organization.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController", description = "Управление информацией об организациях")
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController (OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Получить список всех организаций", httpMethod = "GET")
    @GetMapping("/organizations")
    public List<Organization> all() {
        return organizationService.all();
    }

    @ApiOperation(value = "Получить список организаций по фильтру", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public List<OrganizationFilterViewOut> getOrganizations(@RequestBody OrganizationFilterViewIn organizationFilterViewIn) {
        return organizationService.allByFilter(organizationFilterViewIn);
    }

    @ApiOperation(value = "Получить организацию по ID", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public OrganizationView loadById(@PathVariable Long id) {
        return organizationService.loadById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody OrganizationViewUpdate organizationViewUpdate) {
        organizationService.update(organizationViewUpdate);
    }

    @PostMapping("/save")
    public void save(@RequestBody OrganizationViewSave organizationViewSave) {
        organizationService.save(organizationViewSave);
    }

}
