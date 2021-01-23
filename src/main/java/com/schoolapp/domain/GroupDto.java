package com.schoolapp.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class GroupDto {
    private Long id;
    private String groupName;
    private int minYearOfBirth;
    private int maxYearOfBirth;
    private Localization localization;

    public GroupDto(String groupName, int minYearOfBirth, int maxYearOfBirth, Localization localization) {
        this.groupName = groupName;
        this.minYearOfBirth = minYearOfBirth;
        this.maxYearOfBirth = maxYearOfBirth;
        this.localization = localization;
    }
}
