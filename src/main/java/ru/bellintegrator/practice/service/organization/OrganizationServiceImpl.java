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
import ru.bellintegrator.practice.utils.BadDataException;
import ru.bellintegrator.practice.view.organization.*;

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
        if (organizations.size() == 0) {
            throw new BadDataException();
        }
        return mapperFacade.mapAsList(organizations, OrganizationFilterViewOut.class);
    }

    @ApiOperation(value = "Получить организации по ID", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @Override
    @Transactional
    public OrganizationView loadById(Long id) {
        Organization organization = organizationDao.loadById(id);
        if(organization == null) {
            throw new BadDataException();
        }
        return mapperFacade.map(organization, OrganizationView.class);

    }

    @Override
    @Transactional
    public void save(OrganizationViewSave organizationViewSave) {
        Organization organization = new Organization();
        mapperFacade.map(organizationViewSave, organization);
        organizationDao.save(organization);
    }

    @Override
    @Transactional
    public void update(OrganizationViewUpdate organizationViewUpdate) {
        Organization organization = organizationDao.loadById(organizationViewUpdate.id);
        mapperFacade.map(organizationViewUpdate, organization);
        organizationDao.update(organization);
    }
}
