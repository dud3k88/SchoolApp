package com.schoolapp.repository;

import com.schoolapp.domain.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GroupDao extends CrudRepository<Group, Long> {
    @Override
    List<Group> findAll();

    @Override
    Optional<Group> findById(Long id);

    Optional<Group> findByGroupName(String groupName);

    @Override
    Group save(Group group);

    @Override
    void deleteById(Long id);
}
