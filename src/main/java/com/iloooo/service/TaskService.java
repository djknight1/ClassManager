package com.iloooo.service;

import com.iloooo.entity.Task;

import java.util.List;

public interface TaskService {
    boolean newTask(Task task);

    boolean updateTask(Task task);

    boolean removeTaskById(long id);

    Task getTaskById(long id);

    Task getTaskNowByTypeId(long typeId);

    List<Task> getTaskNow();

    List<Task> getTaskByTypeId(long typeId);

}
