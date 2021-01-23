package com.schoolapp.controller;

import com.schoolapp.domain.Group;
import com.schoolapp.domain.GroupDto;
import com.schoolapp.mapper.GroupMapper;
import com.schoolapp.service.GroupDbService;
import com.schoolapp.service.LocalizationDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/school/groups")
public class GroupController {
    @Autowired
    private GroupDbService service;
    @Autowired
    private LocalizationDbService localizationDbService;

    @Autowired
    private GroupMapper groupMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDto(service.getAllGroups());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) {
       return groupMapper.mapToGroupDto(service.getGroupById(groupId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createGroup", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        service.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) {
        service.deleteGroup(groupId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(service.saveGroup(groupMapper.mapToGroup(groupDto)));
    }


}