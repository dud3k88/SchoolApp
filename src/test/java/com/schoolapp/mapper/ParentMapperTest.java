package com.schoolapp.mapper;

import com.schoolapp.domain.Parent;
import com.schoolapp.domain.ParentDto;
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
public class ParentMapperTest {
    @Autowired
    private ParentMapper mapper;

    @Test
    public void mapToParentListDto() {
        //Given
        List<Parent> parentList = new ArrayList<>(Arrays.asList(
                new Parent("FirstName", "SecondName","email"),
                new Parent("FirstName2", "SecondName2","email2"),
                new Parent("FirstName3", "SecondName3","email3")
        ));

        //when
        List<ParentDto> parentListDto = mapper.mapToParentDtoList(parentList);

        //Then
        assertEquals(parentList.size(), parentListDto.size());
    }

    @Test
    public void mapToParentDto() {
        //Given
        Parent parent =  new Parent("FirstName", "SecondName","email");

        //When
        ParentDto mappedParentDto = mapper.mapToParentDto(parent);

        //Then
        assertEquals(parent.getEmailAddress(), mappedParentDto.getEmailAddress());
    }

    @Test
    public void mapToParent() {
        //Given
        ParentDto parentDto =  new ParentDto(1L, "FirstName", "SecondName","email");

        //When
        Parent mappedParent = mapper.mapToParent(parentDto);

        //Then
        assertEquals(parentDto.getEmailAddress(), mappedParent.getEmailAddress());
    }
}