package com.iloooo.service;

import com.iloooo.bean.Task;
import com.iloooo.bean.Type;
import com.iloooo.bean.User;
import com.iloooo.dao.UserDao;

import java.sql.Timestamp;
import java.util.List;

public interface UpdateService {
    List<Task> getTaskNow();

    List<Type> getTypeAll();

    boolean updateHomework(long userId, long typeId, long taskId, String username);

}
