package ru.bellintegrator.practice.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.utils.BadDataException;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewIn;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewOut;
import ru.bellintegrator.practice.view.organization.OrganizationView;
import ru.bellintegrator.practice.view.organization.OrganizationViewSave;
import ru.bellintegrator.practice.view.organization.OrganizationViewUpdate;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OrganizationFilterViewOut> getOrganizationsByFilter(OrganizationFilterViewIn organizationFilterViewIn) {
        List<Organization> organizations = organizationDao.getOrganizationsByFilter(organizationFilterViewIn);
        if (organizations.size() == 0) {
            throw new BadDataException();
        }
        return mapperFacade.mapAsList(organizations, OrganizationFilterViewOut.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public OrganizationView getOrganizationById(Long id) {
        Organization organization = organizationDao.getOrganizationById(id);
        if(organization == null) {
            throw new BadDataException();
        }
        return mapperFacade.map(organization, OrganizationView.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveOrganization(OrganizationViewSave organizationViewSave) {
        Organization organization = new Organization();
        mapperFacade.map(organizationViewSave, organization);
        organizationDao.saveOrganization(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOrganization(OrganizationViewUpdate organizationViewUpdate) {
        Organization organization = organizationDao.getOrganizationById(organizationViewUpdate.id);
        mapperFacade.map(organizationViewUpdate, organization);
        organizationDao.updateOrganization(organization);
    }
}
