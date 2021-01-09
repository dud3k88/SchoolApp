package com.schoolapp.mapper;


import com.schoolapp.domain.Child;
import com.schoolapp.domain.ChildDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChildMapper {

    public List<ChildDto> mapToChildListDto(List<Child> children) {
        return children.stream()
                .map(child -> new ChildDto(
                        child.getFirstName(),
                        child.getSecondName(),
                        child.getYearOfBirth(),
                        child.getParent().getId(),
                        child.getChildrenGroups()))
                .collect(Collectors.toList());
    }

    public ChildDto mapToChildDto(final Child child) {
        return new ChildDto(
                child.getFirstName(),
                child.getSecondName(),
                child.getYearOfBirth(),
                child.getParentId(),
                child.getChildrenGroups());
    }

    public Child mapToChild (ChildDto childDto) {
        return new Child(
                childDto.getFirstName(),
                childDto.getSecondName(),
                childDto.getYearOfBirth());
    }
}
