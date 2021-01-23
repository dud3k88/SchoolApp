package com.schoolapp.mapper;

import com.schoolapp.domain.Group;
import com.schoolapp.domain.GroupDto;
import com.schoolapp.domain.Localization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupMapperTest {

    @Autowired
    private GroupMapper mapper;

    @Test
    public void mapToGroupDtoList() {
    }

    @Test
    public void testMapToGroupDto() {
        Localization localization = new Localization(1L, "Szkoła1");
        Group group = new Group(1L, "test", 10, 20, localization);

        GroupDto groupDto = mapper.mapToGroupDto(group);

        System.out.println(groupDto.toString());


    }

    @Test
    public void testMapToGroup() {
    }
}