package com.iloooo.bean;

import java.sql.Timestamp;

public class Homework {
    private long Id;
    private long userId;
    private long typeId;
    private long taskId;
    private String name;
    private String path;
    private Timestamp datetime;

    @Override
    public String toString() {
        return "Homework{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", taskId=" + taskId +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    public Homework(long id, long userId, long typeId, long taskId, String name, String path, Timestamp datetime) {
        Id = id;
        this.userId = userId;
        this.typeId = typeId;
        this.taskId = taskId;
        this.name = name;
        this.path = path;
        this.datetime = datetime;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Homework() {

    }
}
