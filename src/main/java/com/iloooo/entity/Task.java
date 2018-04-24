package com.iloooo.entity;

import java.sql.Timestamp;

public class Task {
    private long Id;
    private long typeId;
    private String name;
    private String formatName;
    private Timestamp endTime;
    private int flag;
    private String TaskPath;

    public String getTaskPath() {
        return TaskPath;
    }

    public void setTaskPath(String taskPath) {
        TaskPath = taskPath;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatname) {
        this.formatName = formatname;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Id=" + Id +
                ", typeId=" + typeId +
                ", name='" + name + '\'' +
                ", formatname='" + formatName + '\'' +
                ", flag=" + flag +
                '}';
    }

    public Task(long id, long typeId, String name, String formatname, int flag) {
        Id = id;
        this.typeId = typeId;
        this.name = name;
        this.formatName = formatname;
        this.flag = flag;
    }

    public Task() {

    }
}
