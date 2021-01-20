package com.schoolapp.controller;


import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.schoolapp.domain.Parent;
import com.schoolapp.domain.ParentDto;
import com.schoolapp.mapper.ParentMapper;
import com.schoolapp.service.ParentDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/school/parents")
public class ParentController {
    @Autowired
    private ParentDbService service;

    @Autowired
    private ParentMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getParents")
    public List<ParentDto> getAllParents() {
        return mapper.mapToParentDtoList(service.getAllParents());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getParent")
    public ParentDto getParent(@RequestParam Long parentId) {
        return mapper.mapToParentDto(service.getParent(parentId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteParent")
    public void deleteParent(@RequestParam Long parentId) {
        service.deleteParent(parentId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createParent", consumes = APPLICATION_JSON_VALUE)
    public void createParent(@RequestBody ParentDto parentDto) {
        service.saveParent(mapper.mapToParent(parentDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateParent")
    public ParentDto updateParent(@RequestBody ParentDto parentDto) {
        return mapper.mapToParentDto(service.saveParent(mapper.mapToParent(parentDto)));
    }
}
