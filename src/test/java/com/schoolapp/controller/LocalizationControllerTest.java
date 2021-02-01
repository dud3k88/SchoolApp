package com.schoolapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schoolapp.domain.LocalizationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LocalizationController.class)
public class LocalizationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocalizationController localizationController;

    @Test
    public void shouldFetchEmptyLocalizationList() throws Exception {
        //Given
        List<LocalizationDto> localizationDtoList = new ArrayList<>();
        when(localizationController.getLocalizations()).thenReturn(localizationDtoList);

        //When & Then
        mockMvc.perform(get("/school/localization/getLocalizations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchLocalizationList() throws Exception {
        //Given
        List<LocalizationDto> localizationDtoList = new ArrayList<>();
        localizationDtoList.add(new LocalizationDto(1L, "School1"));

        when(localizationController.getLocalizations()).thenReturn(localizationDtoList);

        //When & Then
        mockMvc.perform(get("/school/localization/getLocalizations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].localizationName", is("School1")));
    }

    @Test
    public void shouldCreateLocalizationDto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/school/localization/createLocalization")
                .content(asJasonString(new LocalizationDto(1L, "Localization1")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteLocalizationDto() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
        .delete("/school/localization/deleteLocalization/{localizationId}", 1))
                .andExpect(status().isOk());
    }



    public static String asJasonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}