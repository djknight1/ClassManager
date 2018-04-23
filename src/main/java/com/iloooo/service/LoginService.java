package com.iloooo.service;


import com.iloooo.bean.User;

import java.util.List;

public interface LoginService {

    User getUserById(long id);

    List<User> selectByClassId(int classId);

    boolean createUser(User user);

    boolean isIdEmpty(long id);

    boolean isCorrectUser(long id, String password);

    boolean updateUser(User user);
}
