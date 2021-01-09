package com.schoolapp.controller;

import com.schoolapp.domain.LocalizationDto;
import com.schoolapp.mapper.LocalizationMapper;
import com.schoolapp.service.LocalizationDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school/localization")
public class LocalizationController {
    @Autowired
    private LocalizationDbService service;

    @Autowired
    private LocalizationMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getLocalizations")
    public List<LocalizationDto> getLocalizations() {
       return mapper.mapToLocalizationDto(service.getAllLocalization());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getLocalization")
    public LocalizationDto getLocalization(@RequestParam Long localizationId) {
        return mapper.mapToLocalizationDto(service.getLocalization(localizationId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteLocalization")
    public void deleteLocalization(@RequestParam Long localizationId) {
        service.deleteLocalization(localizationId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createLocalization")
    public void createLocalization(@RequestBody LocalizationDto localizationDto) {
        service.saveLocalization(mapper.mapToLocalization(localizationDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateLocalization")
    public LocalizationDto updateLocalization(@RequestBody LocalizationDto localizationDto) {
        return mapper.mapToLocalizationDto(service.saveLocalization(mapper.mapToLocalization(localizationDto)));
    }



    }

