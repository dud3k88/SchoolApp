package com.schoolapp.service;

import com.schoolapp.domain.Localization;
import com.schoolapp.repository.LocalizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizationDbService {
    @Autowired
    private LocalizationDao localizationDao;

    public List<Localization> getAllLocalization() {
        return localizationDao.findAll();
    }

    public Localization getLocalization(Long localId) {
        return localizationDao.findById(localId).orElse(null);
    }

    public Localization saveLocalization(Localization localization) {
        return localizationDao.save(localization);
    }

    public void deleteLocalization(Long localId) {
        localizationDao.deleteById(localId);
    }
}
