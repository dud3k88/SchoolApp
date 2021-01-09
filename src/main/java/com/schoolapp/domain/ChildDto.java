package com.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ChildDto {
    private String firstName;
    private String secondName;
    private int yearOfBirth;
    private Long parentId;
    private List<Group> groupDto;
}
