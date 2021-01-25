package com.schoolapp.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChildDto {
    private Long id;
    private String firstName;
    private String secondName;
    private int yearOfBirth;
    private Parent parent;
    private Group group;


}
