package ru.bellintegrator.practice.controller.organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.service.organization.OrganizationService;

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

}
