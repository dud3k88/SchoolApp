package com.schoolapp.mapper;

import com.schoolapp.domain.Group;
import com.schoolapp.domain.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    @Autowired
    private LocalizationMapper localizationMapper;

    public List<GroupDto> mapToGroupDto(List<Group> groupList) {
        return groupList.stream()
                .map(t -> new GroupDto(
                        t.getGroupName(),
                        t.getMinYearOfBirth(),
                        t.getMaxYearOfBirth(),
                        t.getLocalization()))
                .collect(Collectors.toList());
    }

    public GroupDto mapToGroupDto(Group group) {
        return new GroupDto(
                group.getGroupName(),
                group.getMinYearOfBirth(),
                group.getMaxYearOfBirth(),
                group.getLocalization());
    }

    public Group mapToGroup(GroupDto groupDto) {
        return new Group(
                groupDto.getId(),
                groupDto.getGroupName(),
                groupDto.getMinYearOfBirth(),
                groupDto.getMaxYearOfBirth(),
                groupDto.getLocalization());
    }
}
