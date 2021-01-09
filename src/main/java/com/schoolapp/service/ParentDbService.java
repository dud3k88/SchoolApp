package com.schoolapp.service;

import com.schoolapp.domain.Parent;
import com.schoolapp.repository.ParentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentDbService {
    @Autowired
    private ParentDao parentDao;

    public List<Parent> getAllParents() {
        return parentDao.findAll();
    }

    public Parent getParent(Long parentId) {
        return parentDao.findById(parentId).orElse(null);
    }

    public Parent saveParent (Parent parent) {
        return parentDao.save(parent);
    }

    public void deleteParent(Long parentId) {
        parentDao.deleteById(parentId);
    }
}
