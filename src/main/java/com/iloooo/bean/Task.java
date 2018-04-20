package com.iloooo.bean;

public class Task {
    private long Id;
    private long typeId;
    private String name;
    private String formatname;
    private int flag;

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

    public String getFormatname() {
        return formatname;
    }

    public void setFormatname(String formatname) {
        this.formatname = formatname;
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
                ", formatname='" + formatname + '\'' +
                ", flag=" + flag +
                '}';
    }

    public Task(long id, long typeId, String name, String formatname, int flag) {
        Id = id;
        this.typeId = typeId;
        this.name = name;
        this.formatname = formatname;
        this.flag = flag;
    }

    public Task() {

    }
}
