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

    @Test
    public void testSaveParentToDatabase() {
        //Given
        Parent parent1 = new Parent("Parent_name1", "Parent_firstName1", "Parent_secondName1", "address1");
        Parent parent2 = new Parent("Parent_name2", "Parent_firstName2", "Parent_secondName2", "address2");
        Parent parent3 = new Parent("Parent_name3", "Parent_firstName3", "Parent_secondName3", "address3");

        //when
        service.saveParent(parent1);
        service.saveParent(parent2);
        service.saveParent(parent3);

        //Then
        int count = service.getAllParents().size();
        Assert.assertTrue(count >0);

        //CleanUp
        service.deleteParent(parent1.getId());
        service.deleteParent(parent2.getId());
        service.deleteParent(parent3.getId());
    }

    @Test
    public void testSaveParentWithChildren() {
        //Given
        Parent parent = new Parent("Parent_name1", "Parent_firstName1", "Parent_secondName1", "address1");
        Child child1 = new Child("Test_name1", "test_suerName1", 2010);
        Child child2 = new Child("Test_name2", "test_suerName2", 2012);

        parent.setChildren(Arrays.asList(child1, child2));
        child1.setParent(parent);
        child2.setParent(parent);

        //When
        service.saveParent(parent);

        //Then
        Assert.assertTrue(2 == service.getParent(parent.getId()).getChildren().size());
        //CleanUp
        service.deleteParent(parent.getId());
    }

    @Test
    public void testGetParentFromDatabase() {
        //Given
        Parent parent1 = new Parent("Parent_name1", "Parent_firstName1", "Parent_secondName1", "address1");
        Parent parent2 = new Parent("Parent_name2", "Parent_firstName2", "Parent_secondName2", "address2");
        Parent parent3 = new Parent("Parent_name3", "Parent_firstName3", "Parent_secondName3", "address3");

        //when
        service.saveParent(parent1);
        service.saveParent(parent2);
        service.saveParent(parent3);

        //Then
        Parent parentFind = service.getParent(parent1.getId());
        Assert.assertEquals("Parent_name1", parentFind.getName());

        //CleanUp
        service.deleteParent(parent1.getId());
        service.deleteParent(parent2.getId());
        service.deleteParent(parent3.getId());
    }

    @Test
    public void testt() {
        for (Parent parent : service.getAllParents()) {
            service.deleteParent(parent.getId());
        }

    }
}