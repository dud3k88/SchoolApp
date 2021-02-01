package com.schoolapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schoolapp.domain.GroupDto;
import com.schoolapp.domain.Localization;
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
@WebMvcTest(GroupController.class)
public class GroupControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupController groupController;

    @Test
    public void shouldFetchEmptyGroupList() throws Exception {
        //Given
        List<GroupDto> groupDtoList = new ArrayList<>();
        when(groupController.getGroups()).thenReturn(groupDtoList);

        //When & Then
        mockMvc.perform(get("/school/groups/getGroups")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchGroupList() throws Exception {
        //Given
        Localization localization = new Localization(1L, "lok1");

        List<GroupDto> groupDtoList = new ArrayList<>();
        groupDtoList.add(new GroupDto(1L,"GroupName", 2010, 2020, localization));

        when(groupController.getGroups()).thenReturn(groupDtoList);

        //When & Then
        mockMvc.perform(get("/school/groups/getGroups").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].groupName", is("GroupName")))
                .andExpect(jsonPath("$[0].minYearOfBirth", is(2010)))
                .andExpect(jsonPath("$[0].maxYearOfBirth", is(2020)));
    }

    @Test
    public void shouldCreateGroupDto() throws Exception {

        Localization localization = new Localization(1L, "lok1");


        mockMvc.perform(MockMvcRequestBuilders
                .post("/school/groups/createGroup")
                .content(asJasonString(new GroupDto(1L,"GroupName", 2010, 2020, localization)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteGroupDto() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/school/groups/deleteGroup", 1)
                .param("groupId", "1"))
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