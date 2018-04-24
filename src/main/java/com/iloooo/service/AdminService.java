package com.iloooo.service;

import com.iloooo.entity.Admin;

public interface AdminService {
    Admin getAdminByUsername(String username);

    boolean isUsernameEmpty(String username);

    boolean isCorrectAdmin(String username, String password);
}
