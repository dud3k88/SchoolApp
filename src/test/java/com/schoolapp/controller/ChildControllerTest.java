package com.schoolapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schoolapp.domain.*;
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
@WebMvcTest(ChildDto.class)
public class ChildControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChildController childController;

    @Test
    public void shouldFetchEmptyChildList() throws Exception {
        //Given
        List<ChildDto> childDtoList = new ArrayList<>();
        when(childController.getAllChildren()).thenReturn(childDtoList);

        //When & Then
        mockMvc.perform(get("/school/children/getChildren")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchChildrenList() throws Exception {
        //Given
        Localization localization = new Localization(1L, "lok1");
        Group group = new Group(1L, "Name", 2010, 2020, localization);
        Parent parent = new Parent("Jan", "Nowak", "email");

        List<ChildDto> childDtoList = new ArrayList<>();
        childDtoList.add(new ChildDto(1L, "Name", "Name1", 2020, parent, group));

        when(childController.getAllChildren()).thenReturn(childDtoList);

        //When & Then
        mockMvc.perform(get("/school/children/getChildren").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].firstName", is("Name")))
                .andExpect(jsonPath("$[0].secondName", is("Name1")))
                .andExpect(jsonPath("$[0].yearOfBirth", is(2020)));
    }

    @Test
    public void shouldCreateChildDto() throws Exception {

        Localization localization = new Localization(1L, "lok1");
        Group group = new Group(1L, "Name", 2010, 2020, localization);
        Parent parent = new Parent("Jan", "Nowak", "email");


        mockMvc.perform(MockMvcRequestBuilders
                .post("/school/children/createChild")
                .content(asJasonString(new ChildDto(
                        1L,
                        "Name",
                        "Name1",
                        2020,
                        parent,
                        group)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteChildDto() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/school/children/deleteChild", 1)
                .param("childId", "1"))
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

