package com.schoolapp.controller;

import com.schoolapp.domain.Child;
import com.schoolapp.domain.ChildDto;
import com.schoolapp.domain.Parent;
import com.schoolapp.mapper.ChildMapper;
import com.schoolapp.service.ChildDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school/children")
public class ChildController {
    @Autowired
    private ChildDbService service;

    @Autowired
    private ChildMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getChildren")
    public List<ChildDto> getAllChildren() {
        return mapper.mapToChildListDto(service.getAllChildren());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getChild")
    public ChildDto getChild(@RequestParam Long childId) {
        return mapper.mapToChildDto(service.getChild(childId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createChild")
    public void createChild(@RequestBody ChildDto childDto) {
        service.saveChild(mapper.mapToChild(childDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteChild")
    public void deleteChild(@RequestParam Long childId) {
        service.deleteChild(childId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateChild")
    public ChildDto updateChild(@RequestBody ChildDto childDto) {
        return mapper.mapToChildDto(service.saveChild(mapper.mapToChild(childDto)));
    }
}
