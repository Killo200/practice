package ru.bellintegrator.practice.service.office;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.office.OfficeDao;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.utils.BadDataException;
import ru.bellintegrator.practice.view.office.*;
import ru.bellintegrator.practice.view.organization.OrganizationFilterViewOut;
import ru.bellintegrator.practice.view.organization.OrganizationView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;

    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OfficeFilterViewOut> getOfficeByFilter(OfficeFilterViewIn officeFilterViewIn) {
        List<Office> offices = officeDao.getOfficeByFilter(officeFilterViewIn);
        if (offices.size() == 0) {
            throw new BadDataException();
        }
        return mapperFacade.mapAsList(offices, OfficeFilterViewOut.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public OfficeView getOfficeById(Long id) {
        Office office = officeDao.getOfficeById(id);
        if(office == null) {
            throw new BadDataException();
        }
        return mapperFacade.map(office, OfficeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOffice(OfficeViewUpdate officeViewUpdate) {
        Office office = officeDao.getOfficeById(officeViewUpdate.id);
        mapperFacade.map(officeViewUpdate, office);
        officeDao.updateOffice(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveOffice(OfficeViewSave officeViewSave) {
        Office office = new Office();
        mapperFacade.map(officeViewSave, office);
        officeDao.saveOffice(office);
    }
}
