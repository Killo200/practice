package ru.bellintegrator.practice.service.organization;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewIn;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewOut;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public List<Organization> all() {
        List<Organization> all =organizationDao.all();
        return organizationDao.all(); // это из примера, Исправить!!!
        // надо вернуть через маперфасад!
        //return mapperFacade.mapAsList(all, OrganizationView.class);
    }

    @ApiOperation(value = "Получить организации по фильтру ", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @Override
    @Transactional
    public List<OrganizationFilterViewOut> allByFilter(OrganizationFilterViewIn organizationFilterViewIn) {
        List<Organization> organizations = organizationDao.allByFilter(organizationFilterViewIn);
        return mapperFacade.mapAsList(organizations, OrganizationFilterViewOut.class);
    }

    @Override
    @Transactional
    public Organization loadById(Long id) {
        Organization organization = organizationDao.loadById(id);
        //return mapperFacade.map(organization, OrganizationView.class);
        return null;
    }

    @Override
    @Transactional
    public void save(Organization organization) {

    }

    @Override
    @Transactional
    public void update(Organization organization) {

    }
}
