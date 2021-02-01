package com.schoolapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schoolapp.domain.LocalizationDto;
import com.schoolapp.domain.ParentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ParentController.class)
public class ParentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParentController parentController;

    @Test
    public void shouldFetchEmptyParentList() throws Exception {
        //Given
        List<ParentDto> parentDtoList = new ArrayList<>();
        when(parentController.getAllParents()).thenReturn(parentDtoList);

        //When & Then
        mockMvc.perform(get("/school/parents/getParents")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchParentList() throws Exception {
        //Given
        List<ParentDto> parentDtoList = new ArrayList<>();
        parentDtoList.add(new ParentDto(1L, "Name", "Name1", "email"));

        when(parentController.getAllParents()).thenReturn(parentDtoList);

        //When & Then
        mockMvc.perform(get("/school/parents/getParents").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].firstName", is("Name")))
                .andExpect(jsonPath("$[0].secondName", is("Name1")))
                .andExpect(jsonPath("$[0].emailAddress", is("email")));
    }

    @Test
    public void shouldCreateParentDto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/school/parents/createParent")
                .content(asJasonString(new ParentDto(1L, "Name", "Name1", "email")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteParentDto() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/school/parents/deleteParent", 1)
                .param("parentId", "1"))
                .andExpect(status().isOk());
    }


    public static String asJasonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}