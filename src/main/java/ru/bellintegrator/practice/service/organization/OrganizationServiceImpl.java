package ru.bellintegrator.practice.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;

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

    @Transactional
    @Override
    public List<Organization> allByFilter(String name, String inn, boolean isActive) {
        return null;
    }

    @Transactional
    @Override
    public Organization loadById(Long id) {
        return null;
    }

    @Transactional
    @Override
    public void save(Organization organization) {

    }

    @Transactional
    @Override
    public void update(Organization organization) {

    }
}
