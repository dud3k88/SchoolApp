package com.schoolapp.mapper;

import com.schoolapp.domain.Localization;
import com.schoolapp.domain.LocalizationDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalizationMapperTest {

    @Autowired
    private LocalizationMapper mapper;

    @Test
    public void testMapToLocalizationDtoList() {
        //Given
        List<Localization> localizationList = new ArrayList<>(Arrays.asList(
                new Localization(1L, "school1"),
                new Localization(2L, "school2"),
                new Localization(3L, "school3")
        ));

        //When
        List<LocalizationDto> localizationDto = mapper.mapToLocalizationDtoList(localizationList);

        //Then
        Assert.assertEquals(localizationList.size(), localizationDto.size());
    }

    @Test
    public void testMapToLocalizationDto() {
        //Given
        Localization localization = new Localization(1L, "school1");
        LocalizationDto localizationDto = new LocalizationDto(1L, "school1");

        //When
        LocalizationDto mappedLokToDto = mapper.mapToLocalizationDto(localization);

        //Then
        Assert.assertEquals(localizationDto.getId(), mappedLokToDto.getId());
        Assert.assertEquals(localizationDto.getLocalizationName(), mappedLokToDto.getLocalizationName());
    }

    @Test
    public void mapToLocalization() {
        //Given
        Localization localization = new Localization("school1");
        LocalizationDto localizationDto = new LocalizationDto(1L, "school1");

        //when
        Localization localization1 = mapper.mapToLocalization(localizationDto);

        //Then
        Assert.assertEquals(localization.getLocalizationName(), localization1.getLocalizationName());
    }
}