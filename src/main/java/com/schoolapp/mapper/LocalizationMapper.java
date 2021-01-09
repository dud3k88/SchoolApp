package com.schoolapp.mapper;

import com.schoolapp.domain.Localization;
import com.schoolapp.domain.LocalizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocalizationMapper {
    public List<LocalizationDto> mapToLocalizationDto(List<Localization> localizationList) {
        return localizationList.stream()
                .map(localization -> new LocalizationDto(
                        localization.getLocalizationName(),
                        localization.getGroups()))
                .collect(Collectors.toList());
    }

    public LocalizationDto mapToLocalizationDto(final Localization localization) {
        return new LocalizationDto(
                localization.getLocalizationName(),
                localization.getGroups());
    }

    public Localization mapToLocalization(final LocalizationDto localizationDto) {
        return new Localization(
                localizationDto.getLocalizationName()
        );
    }
}
