package com.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ParentDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String emailAddress;
}
