package com.schoolapp.repository;

import com.schoolapp.domain.Parent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParentDao extends CrudRepository <Parent, Long> {

    @Override
    List<Parent> findAll();

    @Override
    Optional<Parent> findById(Long id);

    @Override
    Parent save(Parent parent);

    @Override
    void deleteById(Long id);

}
