package com.schoolapp.repository;

import com.schoolapp.domain.Localization;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocalizationDao extends CrudRepository<Localization, Long> {
    @Override
    List<Localization> findAll();

    @Override
    Optional<Localization> findById(Long id);

    @Override
    Localization save(Localization localization);

    @Override
    void deleteById(Long id);
}
