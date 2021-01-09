package com.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LocalizationDto {
    private String localizationName;
    private List<Group> groupList;

}
