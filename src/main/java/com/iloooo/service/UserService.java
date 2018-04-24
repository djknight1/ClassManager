package com.iloooo.service;

import com.iloooo.entity.User;

import java.util.List;

public interface UserService {

    boolean newUser(User user);

    boolean updateUser(User user);

    boolean removeUser(long id);

    User getUserById(long id);

    List<User> getUserByClassId(long classId);

}
