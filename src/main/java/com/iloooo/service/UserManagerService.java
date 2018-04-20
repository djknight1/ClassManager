package com.iloooo.service;


import com.iloooo.bean.User;

public interface UserManagerService {

    User getUserById(long id);

    boolean createUser(User user);

    boolean isIdEmpty(long id);

    boolean isCorrectUser(long id, String password);
}
