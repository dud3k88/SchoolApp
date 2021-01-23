package com.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class GroupDto {
    private Long id;
    private String groupName;
    private int minYearOfBirth;
    private int maxYearOfBirth;
    private LocalizationDto localizationDto;
}
