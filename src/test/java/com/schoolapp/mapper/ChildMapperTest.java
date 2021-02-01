package com.schoolapp.mapper;

import com.schoolapp.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChildMapperTest {
    @Autowired
    private ChildMapper mapper;

    @Test
    public void mapToChildListDto() {
        Localization localization = new Localization(1L, "School");
        Group group = new Group(1L, "Group1", 10, 20, localization);
        Parent parent =  new Parent("FirstName", "SecondName","email");

        List<Child> children = new ArrayList<>(Arrays.asList(
           new Child(1L, "Name", "SecondName", 20, parent, group),
           new Child(2L, "Name2", "SecondName2", 21, parent, group),
           new Child(3L, "Name3", "SecondName3", 22, parent, group)
        ));

        //When
        List<ChildDto> childrenDto= mapper.mapToChildListDto(children);

        //Then
        assertEquals(children.size(), childrenDto.size());
    }

    @Test
    public void mapToChildDto() {
        //Given
        Localization localization = new Localization(1L, "School");
        Group group = new Group(1L, "Group1", 10, 20, localization);
        Parent parent =  new Parent("FirstName", "SecondName","email");
        Child child = new Child(1L, "Name", "SecondName", 20, parent, group);

        //When
        ChildDto mappedChildDto = mapper.mapToChildDto(child);

        //Then
        assertEquals(child.getId(), mappedChildDto.getId());
    }

    public void mapToChild() {
        //Given
        Localization localization = new Localization(1L, "School");
        Group group = new Group(1L, "Group1", 10, 20, localization);
        Parent parent =  new Parent("FirstName", "SecondName","email");
        ChildDto childDto = new ChildDto(1L, "Name", "SecondName", 20, parent, group);

        //When
        Child mappedChild = mapper.mapToChild(childDto);

        //Then
        assertEquals(childDto.getId(), mappedChild.getId());
    }

}