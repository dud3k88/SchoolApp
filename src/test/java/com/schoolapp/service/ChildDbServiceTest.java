package com.schoolapp.service;

import com.schoolapp.domain.Child;
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

    @Test
    public void testSaveChildWithParent() {
        //Given
        Parent parent = parentDbService.getParent(3L);
        Child child = new Child("Mateusz", "Nowak", 2020, parent);

        //When
        childDbService.saveChild(child);
        Child child1 = childDbService.getChild(child.getId());
        //Then
        Assert.assertEquals(child.getId(), child1.getId());
    }
}