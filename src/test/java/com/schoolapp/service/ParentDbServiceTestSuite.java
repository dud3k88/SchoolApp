package com.schoolapp.service;

import com.schoolapp.domain.Child;
import com.schoolapp.domain.Parent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentDbServiceTestSuite {
    @Autowired
    private ParentDbService service;
    @Autowired
    private ChildDbService dbService;

    @Test
    public void testSaveParentToDatabase() {
        Parent parent = new Parent("test", "test", "test", "Test");
       /* Child child = new Child("Test", "tedsdsddst", 2010);

        parent.setChildren(Arrays.asList(child));
        child.setParent(parent);*/

        service.saveParent(parent);
    }

    @Test
    public void savaChild() {
        Child child = new Child("Test", "test", 2010);
        Parent parent = service.getParent(248L);

        parent.getChildren().add(child);
        child.setParent(parent);

        service.saveParent(parent);
    }

    @Test
    public void savadChild() {
        for (Child child : dbService.getAllChildren()) {
            dbService.deleteChild(child.getId());
        }

        for (Parent child : service.getAllParents()) {
            service.deleteParent(child.getId());
        }
    }

}



