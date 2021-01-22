package com.schoolapp.mapper;

import com.schoolapp.domain.Localization;
import com.schoolapp.domain.LocalizationDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalizationMapperTest {

    @Autowired
    private LocalizationMapper mapper;

    @Test
    public void testMapToLocalizationDtoList() {
    }

    @Test
    public void testMapToLocalizationDto() {
    }

    @Test
    public void mapToLocalization() {
        //Given
        Localization localization = new Localization(1L, "school1");
        LocalizationDto localizationDto = new LocalizationDto(1L, "school1");

        //when
        Localization localization1 = mapper.mapToLocalization(localizationDto);

        //Then
        Assert.assertEquals(localization.getId(), localization1.getId());
        Assert.assertEquals(localization.getLocalizationName(), localization1.getLocalizationName());
    }
}