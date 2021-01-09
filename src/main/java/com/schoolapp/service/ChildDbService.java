package com.schoolapp.service;

import com.schoolapp.domain.Child;
import com.schoolapp.repository.ChildDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildDbService {
    @Autowired
    private ChildDao childDao;

    public List<Child> getAllChildren() {
        return childDao.findAll();
    }

    public Child getChild(Long childId) {
        return childDao.findById(childId).orElse(null);
    }

    public Child saveChild(Child child) {
        return childDao.save(child);
    }

    public void deleteChild(Long childId) {
        childDao.deleteById(childId);
    }
}
