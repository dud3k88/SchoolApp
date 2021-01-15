package com.schoolapp.service;

import com.schoolapp.domain.*;
import com.schoolapp.mapper.ChildMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChildDbServiceTestSuite {
    @Autowired
    private ChildDbService childService;
    @Autowired
    private ParentDbService parentService;
    @Autowired
    private LocalizationDbService localizationService;
    @Autowired
    private GroupDbService groupDbService;
    @Autowired
    private ChildMapper mapper;

    @Test
    public void delete() {
        for (Child child : childService.getAllChildren()) {
            childService.deleteChild(child.getId());
        }
    }

    @Test
    public void deletepar() {
        for (Parent parent : parentService.getAllParents()) {
            parentService.deleteParent(parent.getId());
        }
    }
    @Test
    public void testSaveChild() {
        //Given
        Child child1 = new Child("Name", "Surnam", 10);

        //When
        childService.saveChild(child1);

        //Then
        Assert.assertEquals(child1.getSecondName(), childService.getChild(child1.getId()).getSecondName());

        //CleanUp
        //childService.deleteChild(child1.getId());
    }

    @Test
    public void testDeleteChild() {
        //Given
        Parent parent = new Parent("parent_test", "parent", "parentt", "aaa");
        Child child1 = new Child("Name", "Surnam", 10);
        Child child2 = new Child("Name2", "Surnam2", 10);
        Child child3 = new Child("Name3", "Surnam3", 10);

        parent.setChildren(Arrays.asList(child1, child2, child3));
        child1.setParent(parent);
        child2.setParent(parent);
        child3.setParent(parent);

        parentService.saveParent(parent);

        childService.saveChild(child1);
        childService.saveChild(child2);
        childService.saveChild(child3);

        //When
        int countBeforeDelete = parentService.getParent(parent.getId()).getChildren().size();
        childService.deleteChild(child1.getId());
        childService.deleteChild(child2.getId());
        int countAfterDelete = parentService.getParent(parent.getId()).getChildren().size();

        //Then
        //Assert.assertTrue(countBeforeDelete > countAfterDelete);

        //CleanUp
        parentService.deleteParent(parent.getId());
    }

    @Test
    public void testSaveChildWithGroupsToDatabase() {

    }



    @Test
    public void testSaveChildrenWithParent() {
        Parent parent = new Parent("Test", "Test", "Test", "test");
        Child child1 = new Child("1", "1", 1);
        Child child2 = new Child("2", "2", 2);
        Child child3 = new Child("3", "3", 3);

        parent.setChildren(Arrays.asList(child1, child2, child3));
        child1.setParent(parent);
        child2.setParent(parent);
        child3.setParent(parent);

        parentService.saveParent(parent);
    }
}

