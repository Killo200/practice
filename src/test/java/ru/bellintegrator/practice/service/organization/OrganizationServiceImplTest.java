package ru.bellintegrator.practice.service.organization;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
public class OrganizationServiceImplTest extends TestCase {

    private Organization organization;

    @MockBean
    private OrganizationDao organizationDao;

    @Before
    public void setUp() throws Exception {
        organization = new Organization("Tinkoff", "Tinkoffbank", "7710140679", "773401001", "Москваезд", "", true);
    }

    @Test(expected = EntityExistsException.class)
    public void testSave() {
        Mockito.doThrow(new EntityExistsException("organization already exists"))
                .when(organizationDao)
                .save(organization);

        organizationDao.save(organization);
    }

    public void testUpdate() {
    }
}