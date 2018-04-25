package com.iloooo.service.impl;

import com.iloooo.dao.TaskDao;
import com.iloooo.dao.TypeDao;
import com.iloooo.entity.Type;
import com.iloooo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TypeServiceImpl")
public class TypeServiceImpl implements TypeService {

    private TypeDao typeDao;

    @Autowired
    public TypeServiceImpl(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    public List<Type> getTypeAll() {
        return typeDao.selectTypeAll();
    }

    @Override
    public Type getTypeById(long id) {
        return typeDao.selectTypeById(id);
    }
}
