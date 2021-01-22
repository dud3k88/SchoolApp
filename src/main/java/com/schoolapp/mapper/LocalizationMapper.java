package com.schoolapp.mapper;

import com.schoolapp.domain.Localization;
import com.schoolapp.domain.LocalizationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocalizationMapper {
    public List<LocalizationDto> mapToLocalizationDtoList(final List<Localization> localizationList) {
        return localizationList.stream()
                .map(t -> new LocalizationDto(
                        t.getId(),
                        t.getLocalizationName()))
                .collect(Collectors.toList());
    }

    public LocalizationDto mapToLocalizationDto(final Localization localization) {
        return new LocalizationDto(
                localization.getId(),
                localization.getLocalizationName());
    }

    public Localization mapToLocalization(final LocalizationDto localizationDto) {
        return new Localization(
                localizationDto.getId(),
                localizationDto.getLocalizationName());
    }
}
