package ru.bellintegrator.practice.service.organization;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;
import ru.bellintegrator.practice.dao.organization.*;
import ru.bellintegrator.practice.model.*;
import ru.bellintegrator.practice.view.organization.*;

import java.util.*;

@RunWith(SpringRunner.class)
public class OrganizationServiceImplTest extends TestCase {

    private Organization organization;
    private OrganizationFilterViewIn organizationFilterViewIn;
    private List<Organization> organizationList;

    @MockBean
    private OrganizationDao organizationDao;

    public void setUp() throws Exception {
        organizationList = new ArrayList<>();
        organization = new Organization( "Tinkofffff", "Tinkoffbank", "7710140679", "773401001", "Москваезд", "", true);
        organizationList.add(organization);
    }

    @Test
    public void testGetOrganizationsByFilter() {
        Mockito.doReturn(organizationList)
                .when(organizationDao)
                .getOrganizationsByFilter(organizationFilterViewIn);

        List<Organization> list = organizationDao.getOrganizationsByFilter(organizationFilterViewIn);

        Assert.assertEquals(list, organizationList);
    }

    public void testGetOrganizationById() {
    }

    public void testSaveOrganization() {
    }

    public void testUpdateOrganization() {
    }
}