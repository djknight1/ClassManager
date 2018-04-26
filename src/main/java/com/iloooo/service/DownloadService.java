package com.iloooo.service;

import com.iloooo.entity.Class;
import com.iloooo.entity.Homework;
import com.iloooo.entity.Task;
import com.iloooo.entity.Type;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface DownloadService {
    List<Task> getTaskNow();

    List<Homework> getHomewordByTaskId(long taskId);

    List<Class> getClassAll();

    List<Type> getTypeAll();

    List<Task> getTaskByTypeId(long typeId);

//    void downloadAll(String path, String taskName) throws IOException, ServletException;

}
