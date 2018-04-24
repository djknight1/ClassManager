package com.iloooo.service;
import com.iloooo.entity.Class;

import java.util.List;

public interface ClassService {
    Class getClassById(long id);

    Class getClassByClassName(String className);

    List<Class> getClassAll();
}
