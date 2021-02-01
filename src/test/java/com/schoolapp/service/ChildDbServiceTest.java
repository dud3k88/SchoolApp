package com.schoolapp.service;

import com.schoolapp.domain.Child;
import com.schoolapp.domain.Group;
import com.schoolapp.domain.Localization;
import com.schoolapp.domain.Parent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChildDbServiceTest {

    @Autowired
    private ChildDbService childDbService;
    @Autowired
    private ParentDbService parentDbService;
    @Autowired
    private GroupDbService groupDbService;
    @Autowired
    private LocalizationDbService localizationDbService;

    @Test
    public void getAllChildren() {
        //Given
        Localization localization = new Localization("local");
        Group group = new Group("Group", 10, 20, localization);
        Parent parent = new Parent("Name", "Surname", "email@wp.pl");
        Child child1 = new Child("Child1", "Child1", 2001, parent, group);
        Child child2 = new Child("Child2", "Child2", 2001, parent, group);
        Child child3 = new Child("Child3", "Child3", 2001, parent, group);

        localizationDbService.saveLocalization(localization);
        groupDbService.saveGroup(group);
        parentDbService.saveParent(parent);
        childDbService.saveChild(child1);
        childDbService.saveChild(child2);
        childDbService.saveChild(child3);

        //When
        int size = childDbService.getAllChildren().size();

        //Then
        assertEquals(3, size);

        //CleanUp
        cleanUp();
    }

    @Test
    public void getChild() {
        //Given
        Localization localization = new Localization("local");
        Group group = new Group("Group", 10, 20, localization);
        Parent parent = new Parent("Name", "Surname", "email@wp.pl");
        Child child1 = new Child("Child1", "Child1", 2001, parent, group);

        localizationDbService.saveLocalization(localization);
        groupDbService.saveGroup(group);
        parentDbService.saveParent(parent);
        childDbService.saveChild(child1);

        //When
        Child getChild = childDbService.getChild(child1.getId());

        //Then
        assertEquals(child1.getFirstName(), getChild.getFirstName());

        //CleanUp
        cleanUp();
    }

    @Test
    public void saveChild() {
        //Given
        Localization localization = new Localization("local");
        Group group = new Group("Group", 10, 20, localization);
        Parent parent = new Parent("Name", "Surname", "email@wp.pl");
        Child child1 = new Child("Child1", "Child1", 2001, parent, group);
        Child child2 = new Child("Child2", "Child2", 2001, parent, group);
        Child child3 = new Child("Child3", "Child3", 2001, parent, group);

        localizationDbService.saveLocalization(localization);
        groupDbService.saveGroup(group);
        parentDbService.saveParent(parent);

        //When
        childDbService.saveChild(child1);
        childDbService.saveChild(child2);
        childDbService.saveChild(child3);

        //Then
        int size = childDbService.getAllChildren().size();
        assertTrue(size > 0);

        //CleanUp
        cleanUp();

    }

    @Test
    public void deleteChild() {
        //Given
        Localization localization = new Localization("local");
        Group group = new Group("Group", 10, 20, localization);
        Parent parent = new Parent("Name", "Surname", "email@wp.pl");
        Child child1 = new Child("Child1", "Child1", 2001, parent, group);
        Child child2 = new Child("Child2", "Child2", 2001, parent, group);
        Child child3 = new Child("Child3", "Child3", 2001, parent, group);

        localizationDbService.saveLocalization(localization);
        groupDbService.saveGroup(group);
        parentDbService.saveParent(parent);
        childDbService.saveChild(child1);
        childDbService.saveChild(child2);
        childDbService.saveChild(child3);

        //When
        cleanUp();

        //Then
        int size = childDbService.getAllChildren().size();
        assertEquals(0, size);
    }

    @Test
    public void cleanUp() {


        for (Child child : childDbService.getAllChildren()) {
            childDbService.deleteChild(child.getId());
        }
        for (Group gr : groupDbService.getAllGroups()) {
            groupDbService.deleteGroup(gr.getId());
        }
        for (Localization local : localizationDbService.getAllLocalization()) {
            localizationDbService.deleteLocalization(local.getId());
        }
        for (Parent par : parentDbService.getAllParents()) {
            parentDbService.deleteParent(par.getId());
        }


    }
}