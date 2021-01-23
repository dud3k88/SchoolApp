package com.schoolapp.controller;

import com.google.gson.Gson;
import com.schoolapp.domain.Group;
import com.schoolapp.domain.GroupDto;
import com.schoolapp.domain.Localization;
import com.schoolapp.mapper.GroupMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GroupControllerTest {

    @Autowired
    GroupMapper groupMapper;

    @Test
    public void test() {
    }

}