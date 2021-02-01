package com.schoolapp.service;

import com.schoolapp.domain.Parent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentDbServiceTest {
    @Autowired
    private ParentDbService service;

    @Test
    public void getAllParents() {
        //Given
        Parent parent1 = new Parent("Name1", "Surname1", "email1");
        Parent parent2 = new Parent("Name2", "Surname2", "email2");
        Parent parent3 = new Parent("Name3", "Surname3", "email3");
        Parent parent4 = new Parent("Name4", "Surname4", "email4");

        service.saveParent(parent1);
        service.saveParent(parent2);
        service.saveParent(parent3);
        service.saveParent(parent4);

        //When
        List<Parent> allParents = service.getAllParents();

        //Then
        assertEquals(4, allParents.size());

        //CleanUp
        for (Parent parent : service.getAllParents()) {
            service.deleteParent(parent.getId());
        }
    }

    @Test
    public void getParent() {
        //Given
        Parent parent1 = new Parent("Name1", "Surname1", "email1");
        Parent parent2 = new Parent("Name2", "Surname2", "email2");
        Parent parent3 = new Parent("Name3", "Surname3", "email3");
        Parent parent4 = new Parent("Name4", "Surname4", "email4");

        service.saveParent(parent1);
        service.saveParent(parent2);
        service.saveParent(parent3);
        service.saveParent(parent4);

        //When
        Parent serviceParent = service.getParent(parent1.getId());

        //Then
        assertEquals(parent1.getFirstName(), serviceParent.getFirstName());

        //CleanUp
        for (Parent parent : service.getAllParents()) {
            service.deleteParent(parent.getId());
        }

    }

    @Test
    public void saveParent() {
        //Given
        Parent parent1 = new Parent("Name1", "Surname1", "email1");
        service.saveParent(parent1);

        //When
        Parent serviceParent = service.getParent(parent1.getId());

        //Then
        assertEquals(parent1.getFirstName(), serviceParent.getFirstName());

        //CleanUp
        for (Parent parent : service.getAllParents()) {
            service.deleteParent(parent.getId());
        }
    }

    @Test
    public void deleteParent() {
        //Given
        Parent parent1 = new Parent("Name1", "Surname1", "email1");
        Parent parent2 = new Parent("Name2", "Surname2", "email2");
        Parent parent3 = new Parent("Name3", "Surname3", "email3");
        Parent parent4 = new Parent("Name4", "Surname4", "email4");

        service.saveParent(parent1);
        service.saveParent(parent2);
        service.saveParent(parent3);
        service.saveParent(parent4);

        //When
        service.deleteParent(parent1.getId());
        service.deleteParent(parent3.getId());

        //Then
        assertEquals(2, service.getAllParents().size());

        //CleanUp
        for (Parent parent : service.getAllParents()) {
            service.deleteParent(parent.getId());
        }

    }
}