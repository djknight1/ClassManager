package com.iloooo.service;

import com.iloooo.bean.Class;
import com.iloooo.bean.Homework;
import com.iloooo.bean.Task;
import com.iloooo.bean.Type;

import java.util.List;

public interface DownloadService {
    List<Task> getTaskNow();

    List<Homework> getHomewordByTaskId(long taskId);

    List<Class> getClassAll();

    List<Type> getTypeAll();

    List<Task> getTaskByTypeId(long typeId);

}
