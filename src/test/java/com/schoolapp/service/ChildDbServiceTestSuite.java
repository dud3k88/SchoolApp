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

    }
    @Test
    public void testSaveChildWithGroupsToDatabase() {


    }



    @Test
    public void testSaveChildrenWithParent() {

    }
}

