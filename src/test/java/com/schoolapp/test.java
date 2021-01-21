package com.schoolapp;

import com.schoolapp.domain.Child;
import com.schoolapp.domain.Parent;
import com.schoolapp.service.ChildDbService;
import com.schoolapp.service.GroupDbService;
import com.schoolapp.service.ParentDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    ParentDbService parentDbService;
    @Autowired
    ChildDbService childDbService;
    @Autowired
    GroupDbService groupDbService;

    @Test
    public void test() {
       /* Child child = childDbService.getChild(10L);

        child.setGroup(groupDbService.getGroupById(1L));

        childDbService.saveChild(child);*/
    }
}
