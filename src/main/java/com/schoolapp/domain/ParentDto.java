package com.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class ParentDto {
    private String name;
    private String firstName;
    private String secondName;
    private String emailAddress;
    private List<ChildDto> childDtoList;
}
