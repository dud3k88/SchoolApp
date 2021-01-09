package com.schoolapp.repository;

import com.schoolapp.domain.Child;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChildDao extends CrudRepository <Child, Long> {
    @Override
    List<Child> findAll();

    @Override
    Optional<Child> findById(Long id);

    @Override
    Child save(Child child);

    @Override
    void deleteById(Long id);
}
