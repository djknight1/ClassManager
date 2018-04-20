package com.iloooo.bean;

import java.sql.Timestamp;

public class Homework {
    private long Id;
    private long userId;
    private long typeId;
    private long taskId;
    private String path;
    private Timestamp datetime;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "HomeworkDao{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", taskId=" + taskId +
                ", path='" + path + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    public Homework(long id, long userId, long typeId, long taskId, String path, Timestamp datetime) {
        Id = id;
        this.userId = userId;
        this.typeId = typeId;
        this.taskId = taskId;
        this.path = path;
        this.datetime = datetime;
    }

    public Homework() {

    }
}
