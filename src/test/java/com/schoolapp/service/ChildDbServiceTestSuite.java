package com.schoolapp.service;

import com.schoolapp.domain.*;
import com.schoolapp.mapper.ChildMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChildDbServiceTestSuite {
    @Autowired
    private ChildDbService childService;
    @Autowired
    private ParentDbService parentService;
    @Autowired
    private LocalizationDbService localizationService;
    @Autowired
    private GroupDbService groupDbService;
    @Autowired
    private ChildMapper mapper;


}

