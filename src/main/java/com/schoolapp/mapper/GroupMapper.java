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

    public List<GroupDto> mapToGroupDto(final List<Group> groupList) {
        return groupList.stream()
                .map(t -> new GroupDto(
                        t.getId(),
                        t.getGroupName(),
                        t.getMinYearOfBirth(),
                        t.getMaxYearOfBirth(),
                        localizationMapper.mapToLocalizationDto(t.getLocalization())))
                .collect(Collectors.toList());
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(
                group.getId(),
                group.getGroupName(),
                group.getMinYearOfBirth(),
                group.getMaxYearOfBirth(),
                localizationMapper.mapToLocalizationDto(group.getLocalization()));
    }

    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(
                groupDto.getGroupName(),
                groupDto.getMinYearOfBirth(),
                groupDto.getMaxYearOfBirth(),
                localizationMapper.mapToLocalization(groupDto.getLocalizationDto()));
    }
}
