package com.iloooo.service.impl;

import com.iloooo.dao.TaskDao;
import com.iloooo.entity.Task;
import com.iloooo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TaskServiceImpl")
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;

    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public boolean newTask(Task task) {
        return taskDao.insertTask(task);
    }

    @Override
    public boolean updateTask(Task task) {
        return taskDao.updateTask(task);
    }

    @Override
    public boolean removeTaskById(long id) {
        return taskDao.deleteTaskById(id);
    }

    @Override
    public Task getTaskById(long id) {
        return taskDao.selectByTaskId(id);
    }

    @Override
    public Task getTaskNowByTypeId(long typeId) {
        return taskDao.selectTaskNowByTypeId(typeId);
    }

    @Override
    public List<Task> getTaskNow() {
        return taskDao.selectTaskNow();
    }

    @Override
    public List<Task> getTaskByTypeId(long typeId) {
        return taskDao.selectTaskByTypeId(typeId);
    }

}
