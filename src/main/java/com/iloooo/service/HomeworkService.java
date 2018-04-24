package com.iloooo.service;

import com.iloooo.entity.Homework;

import java.util.List;

public interface HomeworkService {
    boolean newHomework(Homework homework);

    boolean removeHomeworkById(long id);

    boolean updateHomework(Homework homework);

    List<Homework> getHomeworkAll();

    List<Homework> getHomeworkListByUserId(long userId);

    List<Homework> getHomeworkByTypeId(long typeId);

    Homework getHomeworkByUserIdAndTaskId(long userId, long TaskId);

}
