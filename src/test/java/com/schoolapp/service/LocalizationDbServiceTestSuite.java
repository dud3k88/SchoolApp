package com.schoolapp.service;

import com.schoolapp.domain.Group;
import com.schoolapp.domain.Localization;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalizationDbServiceTestSuite {
    @Autowired
    private LocalizationDbService service;

    @Test
    public void testSaveLocalizationToDatabase() {
        //Given
        Localization localization1 = new Localization("School1");
        Localization localization2 = new Localization("School2");
        Localization localization3 = new Localization("School3");

        //When
        service.saveLocalization(localization1);
        service.saveLocalization(localization2);
        service.saveLocalization(localization3);

        //Then
        Assert.assertEquals(3, service.getAllLocalization().size());

        //CleanUp
        service.deleteLocalization(localization1.getId());
        service.deleteLocalization(localization2.getId());
        service.deleteLocalization(localization3.getId());
    }

    @Test
    public void testDeleteLocalization() {
        //Given
        Localization localization1 = new Localization("School1");
        Localization localization2 = new Localization("School2");
        Localization localization3 = new Localization("School3");

        //When
        service.saveLocalization(localization1);
        service.saveLocalization(localization2);
        service.saveLocalization(localization3);

        int countBeforeDelete = service.getAllLocalization().size();

        service.deleteLocalization(localization1.getId());
        service.deleteLocalization(localization2.getId());
        service.deleteLocalization(localization3.getId());

        int countAfterDelete = service.getAllLocalization().size();

        //Then
        Assert.assertTrue(countBeforeDelete > countAfterDelete);
    }

    @Test
    public void testSaveLocalizationWithGroups() {
        //Given
        Localization localization = new Localization("Local1");
        Group group = new Group("gropup1", 10, 20);
        Group group2 = new Group("gropup2", 10, 20);

        localization.setGroups(Arrays.asList(group, group2));
        group.setLocalization(localization);
        group2.setLocalization(localization);

        //When
        service.saveLocalization(localization);

        //Then
        Assert.assertTrue(service.getLocalization(localization.getId()).getGroups().size() == 2);

        //CleanUp
        service.deleteLocalization(localization.getId());
    }

    @Test
    public void deleteAllLocal() {
        for (Localization localization : service.getAllLocalization()) {
            service.deleteLocalization(localization.getId());
        }
    }

}