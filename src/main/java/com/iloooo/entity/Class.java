package com.iloooo.entity;

public class Class {
    private long Id;
    private String classname;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "Class{" +
                "Id=" + Id +
                ", classname='" + classname + '\'' +
                '}';
    }

    public Class(long id, String classname) {
        Id = id;
        this.classname = classname;
    }

    public Class() {

    }
}
