package com.schoolapp.mapper;

import com.schoolapp.domain.Group;
import com.schoolapp.domain.GroupDto;
import com.schoolapp.domain.Localization;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupMapperTest {

    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void mapToGroupDtoList() {
        //Given
        Localization localization = new Localization(1L, "School");
        List<Group> groupList = new ArrayList<>(Arrays.asList(
                new Group(1L, "Group1", 10, 20, localization),
                new Group(2L, "Group2", 10, 20, localization),
                new Group(3L, "Group3", 10, 20, localization)
        ));

        //When
        List<GroupDto> groupListDto = groupMapper.mapToGroupListDto(groupList);

        //Then
        Assert.assertEquals(groupList.size(), groupListDto.size());
    }

    @Test
    public void mapToGroupDto() {
        //Given
        Localization localization = new Localization(1L, "School");
        Group group = new Group(1L, "Group1", 10, 20, localization);

        //When
        GroupDto mappedGroupDto = groupMapper.mapToGroupDto(group);

        //Then
        Assert.assertEquals(group.getGroupName(), mappedGroupDto.getGroupName());
    }

    @Test
    public void mapToGroup() {
        //Given
        Localization localization = new Localization(1L, "School");
        GroupDto groupDto = new GroupDto(1L, "Group1", 10, 20, localization);

        //When
        Group mappedGroup = groupMapper.mapToGroup(groupDto);

        //Then
        Assert.assertEquals(groupDto.getGroupName(), mappedGroup.getGroupName());
    }
}