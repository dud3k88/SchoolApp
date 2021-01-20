package com.schoolapp.mapper;

import com.schoolapp.domain.Parent;
import com.schoolapp.domain.ParentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParentMapper {

    public List<ParentDto> mapToParentDtoList(final List<Parent> parentList) {
        return parentList.stream()
                .map(t -> new ParentDto(
                        t.getId(),
                        t.getFirstName(),
                        t.getSecondName(),
                        t.getEmailAddress()))
                .collect(Collectors.toList());
    }

        public ParentDto mapToParentDto(final Parent parent) {
            return new ParentDto(
                    parent.getId(),
                    parent.getFirstName(),
                    parent.getSecondName(),
                    parent.getEmailAddress());
        }

    public Parent mapToParent(final ParentDto parentDto) {
        return new Parent(
                parentDto.getFirstName(),
                parentDto.getSecondName(),
                parentDto.getEmailAddress());
    }
}
