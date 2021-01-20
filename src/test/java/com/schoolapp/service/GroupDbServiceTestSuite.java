package com.schoolapp.service;

import com.schoolapp.domain.Child;
import com.schoolapp.domain.Group;
import com.schoolapp.domain.Localization;
import com.schoolapp.domain.Parent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDbServiceTestSuite {

    @Autowired
    private ChildDbService childDbService;
    @Autowired
    private GroupDbService groupDbService;
    @Autowired
    private LocalizationDbService localizationDbService;
    @Autowired
    private ParentDbService parentDbService;

    @Test
    public void testSaveGroupWithChildAndLocalization() {
    }


}