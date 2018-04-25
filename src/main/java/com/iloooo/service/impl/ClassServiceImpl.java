package com.iloooo.service.impl;

import com.iloooo.dao.ClassDao;
import com.iloooo.entity.Class;
import com.iloooo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("classServiceImpl")
public class ClassServiceImpl implements ClassService {

    private ClassDao classDao;

    @Autowired
    public ClassServiceImpl(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public Class getClassById(long id) {
        return classDao.selectById(id);
    }

    @Override
    public Class getClassByClassName(String className) {
        return null;
    }

    @Override
    public List<Class> getClassAll() {
        return null;
    }
}
