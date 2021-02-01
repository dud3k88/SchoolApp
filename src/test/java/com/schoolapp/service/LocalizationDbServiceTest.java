package com.schoolapp.service;

import com.schoolapp.domain.Localization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalizationDbServiceTest {

    @Autowired
    private LocalizationDbService service;

    @Test
    public void TestGetAllLocalization() {
        //Given
        Localization localization1 = new Localization("School1");
        Localization localization2 = new Localization("School2");
        Localization localization3 = new Localization("School3");

        service.saveLocalization(localization1);
        service.saveLocalization(localization2);
        service.saveLocalization(localization3);

        //When
        List<Localization> allLocalization = service.getAllLocalization();

        //Then
        assertEquals(3, allLocalization.size());

        //CleanUp
        for (Localization localization : service.getAllLocalization()) {
            service.deleteLocalization(localization.getId());
        }
    }

    @Test
    public void getLocalization() {
        //Given
        Localization localization = new Localization("School1");
        service.saveLocalization(localization);
        //When
        Localization getLocalization = service.getLocalization(localization.getId());

        //Then
        assertEquals(localization.getLocalizationName(), getLocalization.getLocalizationName());

        //CleanUp
        for (Localization local : service.getAllLocalization()) {
            service.deleteLocalization(local.getId());
        }
    }

    @Test
    public void saveLocalization() {
        //Given
        Localization localization = new Localization("School1");
        Localization localization2 = new Localization("School2");
        Localization localization3 = new Localization("School3");
        Localization localization4 = new Localization("School4");

        //When
        service.saveLocalization(localization);
        service.saveLocalization(localization2);
        service.saveLocalization(localization3);
        service.saveLocalization(localization4);

        //Then
        assertEquals(4, service.getAllLocalization().size());

        //CleanUp
        for (Localization local : service.getAllLocalization()) {
            service.deleteLocalization(local.getId());
        }
    }

    @Test
    public void deleteLocalization() {
        //Given
        Localization localization = new Localization("School1");
        Localization localization2 = new Localization("School2");
        Localization localization3 = new Localization("School3");
        Localization localization4 = new Localization("School4");

        service.saveLocalization(localization);
        service.saveLocalization(localization2);
        service.saveLocalization(localization3);
        service.saveLocalization(localization4);

        //When
        service.deleteLocalization(localization2.getId());
        service.deleteLocalization(localization4.getId());

        //Then
        assertEquals(2, service.getAllLocalization().size());

        //CleanUp
        for (Localization local : service.getAllLocalization()) {
            service.deleteLocalization(local.getId());
        }

    }
}