package com.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ChildDto {
    private Long id;
    private String firstName;
    private String secondName;
    private int yearOfBirth;
    private List<Group> groupDto;
}
