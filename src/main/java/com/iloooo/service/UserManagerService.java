package com.iloooo.service;


import com.iloooo.bean.User;

public interface UserManagerService {
    User getUserByUsername(String username);

    User getUserById(long id);

    boolean createUser(User user);

    boolean isUsernameEmpty(String username);

    boolean isCorrectUser(String username, String password);
}
