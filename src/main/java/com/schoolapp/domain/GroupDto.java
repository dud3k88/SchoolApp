package com.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter

public class GroupDto {
    private Long id;
    private String groupName;
    private int minYearOfBirth;
    private int maxYearOfBirth;
    private LocalizationDto localizationDto;

    public GroupDto(String groupName, int minYearOfBirth, int maxYearOfBirth, LocalizationDto localizationDto) {
        this.groupName = groupName;
        this.minYearOfBirth = minYearOfBirth;
        this.maxYearOfBirth = maxYearOfBirth;
        this.localizationDto = localizationDto;
    }
}
