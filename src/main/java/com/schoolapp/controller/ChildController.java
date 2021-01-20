package com.schoolapp.controller;

import com.schoolapp.domain.Child;
import com.schoolapp.domain.ChildDto;
import com.schoolapp.mapper.ChildMapper;
import com.schoolapp.service.ChildDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/school/children")
public class ChildController {
    @Autowired
    private ChildDbService service;

    @Autowired
    private ChildMapper childMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getChildren")
    public List<Child> getAllChildren() {
        return service.getAllChildren();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getChild")
    public ChildDto getChild(@RequestParam Long childId) {
        return childMapper.mapToChildDto(service.getChild(childId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createChild", consumes = APPLICATION_JSON_VALUE)
    public void createChild(@RequestBody ChildDto childDto) {
        service.saveChild(childMapper.mapToChild(childDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteChild")
    public void deleteChild(@RequestParam Long childId) {
        service.deleteChild(childId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateChild")
    public ChildDto updateChild(@RequestBody ChildDto childDto) {
        return childMapper.mapToChildDto(service.saveChild(childMapper.mapToChild(childDto)));
    }
}
