package com.iloooo.service;

import com.iloooo.entity.Type;

import java.util.List;

public interface TypeService {
    List<Type> getTypeAll();

    Type getTypeById(long id);

}
