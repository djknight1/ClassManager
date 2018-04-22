package com.iloooo.service;

import com.iloooo.bean.Admin;

import java.util.List;

public interface AdminService {
    Admin getAdminByUsername(String username);

    boolean isUsernameEmpty(String username);

    boolean isCorrectAdmin(String username, String password);
}
