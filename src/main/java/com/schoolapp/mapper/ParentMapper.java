package com.schoolapp.mapper;

import com.schoolapp.domain.Parent;
import com.schoolapp.domain.ParentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParentMapper {

    @Autowired
    private ChildMapper childMapper;

    public List<ParentDto> mapToParentDtoList(final List<Parent> parentList) {
        return parentList.stream()
                .map(parent -> new ParentDto(
                        parent.getId(),
                        parent.getName(),
                        parent.getFirstName(),
                        parent.getSecondName(),
                        parent.getEmailAddress(),
                        childMapper.mapToChildListDto(parent.getChildren())))
                .collect(Collectors.toList());
    }

    public ParentDto mapToParentDto(final Parent parent) {
        return new ParentDto(
                parent.getId(),
                parent.getName(),
                parent.getFirstName(),
                parent.getSecondName(),
                parent.getEmailAddress(),
                childMapper.mapToChildListDto(parent.getChildren()));
    }

    public Parent mapToParent(final ParentDto parentDto) {
        return new Parent(
                parentDto.getName(),
                parentDto.getFirstName(),
                parentDto.getSecondName(),
                parentDto.getEmailAddress()
        );
    }
}
