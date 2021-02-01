package com.schoolapp.service;

import com.schoolapp.domain.Group;
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
public class GroupDbServiceTest {
    @Autowired
    private GroupDbService service;
    @Autowired
    private LocalizationDbService localizationDbService;

    @Test
    public void getAllGroups() {
        //Given
        Localization localization = new Localization("School");
        Group group = new Group("Group", 2020, 2021, localization);
        Group group1 = new Group("Group1", 2020, 2021, localization);
        Group group2 = new Group("Group2", 2020, 2021, localization);

        localizationDbService.saveLocalization(localization);
        service.saveGroup(group);
        service.saveGroup(group1);
        service.saveGroup(group2);

        //When
        List<Group> allGroups = service.getAllGroups();

        //Then
        assertEquals(3, allGroups.size());

        //CleanUp
        for (Group gr : service.getAllGroups()) {
            service.deleteGroup(gr.getId());
        }
        for (Localization local : localizationDbService.getAllLocalization()) {
            localizationDbService.deleteLocalization(local.getId());
        }

    }

    @Test
    public void getGroupById() {
        //Given
        Localization localization = new Localization("School");
        Group group = new Group("Group", 2020, 2021, localization);

        localizationDbService.saveLocalization(localization);
        service.saveGroup(group);

        //When
        Group groupById = service.getGroupById(group.getId());

        //Then
        assertEquals(group.getGroupName(), groupById.getGroupName());

        //CleanUp
        for (Group gr : service.getAllGroups()) {
            service.deleteGroup(gr.getId());
        }
        for (Localization local : localizationDbService.getAllLocalization()) {
            localizationDbService.deleteLocalization(local.getId());
        }
    }

    @Test
    public void saveGroup() {
        //Given
        Localization localization = new Localization("School");
        Group group = new Group("Group", 2020, 2021, localization);
        Group group1 = new Group("Group1", 2020, 2021, localization);
        Group group2 = new Group("Group2", 2020, 2021, localization);

        //When
        localizationDbService.saveLocalization(localization);
        service.saveGroup(group);
        service.saveGroup(group1);
        service.saveGroup(group2);

        //Then
        int size = service.getAllGroups().size();
        assertEquals(3, size);

        //CleanUp
        for (Group gr : service.getAllGroups()) {
            service.deleteGroup(gr.getId());
        }
        for (Localization local : localizationDbService.getAllLocalization()) {
            localizationDbService.deleteLocalization(local.getId());
        }

    }

    @Test
    public void deleteGroup() {
        //Given
        Localization localization = new Localization("School");
        Group group = new Group("Group", 2020, 2021, localization);
        Group group1 = new Group("Group1", 2020, 2021, localization);
        Group group2 = new Group("Group2", 2020, 2021, localization);

        localizationDbService.saveLocalization(localization);
        service.saveGroup(group);
        service.saveGroup(group1);
        service.saveGroup(group2);

        //When
        service.deleteGroup(group1.getId());

        //Then
        assertEquals(2, service.getAllGroups().size());

        //CleanUp
        for (Group gr : service.getAllGroups()) {
            service.deleteGroup(gr.getId());
        }
        for (Localization local : localizationDbService.getAllLocalization()) {
            localizationDbService.deleteLocalization(local.getId());
        }
    }
}