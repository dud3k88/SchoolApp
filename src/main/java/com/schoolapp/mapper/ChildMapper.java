package com.schoolapp.mapper;

import com.schoolapp.domain.Child;
import com.schoolapp.domain.ChildDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChildMapper {

    @Autowired
    private ParentMapper parentMapper;
    @Autowired
    private GroupMapper groupMapper;

    public List<ChildDto> mapToChildListDto(List<Child> children) {
        return children.stream()
                .map(t -> new ChildDto(
                        t.getId(),
                        t.getFirstName(),
                        t.getSecondName(),
                        t.getYearOfBirth(),
                        t.getParent(),
                        t.getGroup()))
                .collect(Collectors.toList());
    }

    public ChildDto mapToChildDto(final Child child) {
        return new ChildDto(
                child.getId(),
                child.getFirstName(),
                child.getSecondName(),
                child.getYearOfBirth(),
                child.getParent(),
                child.getGroup());
    }

    public Child mapToChild(ChildDto childDto) {
        return new Child(
                childDto.getId(),
                childDto.getFirstName(),
                childDto.getSecondName(),
                childDto.getYearOfBirth(),
                childDto.getParent(),
                childDto.getGroup());
    }
}