package com.iloooo.service;


import com.iloooo.entity.User;

import java.util.List;

public interface LoginService {




    boolean createUser(User user);

    boolean isIdEmpty(long id);

    boolean isCorrectUser(long id, String password);

}
