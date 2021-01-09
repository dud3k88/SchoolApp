package com.schoolapp.service;

import com.schoolapp.domain.Group;
import com.schoolapp.repository.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupDbService {
    @Autowired
    private GroupDao groupDao;

    public List<Group> getAllGroups() {
        return groupDao.findAll();
    }

    public Group getGroupById(final Long groupId) {
        return groupDao.findById(groupId).orElse(null);
    }

    public Group saveGroup(final Group group) {
        return groupDao.save(group);
    }

    public void deleteGroup(final Long groupId) {
        groupDao.deleteById(groupId);
    }
}
