package com.iloooo.bean;

public class Type {
    private long id;
    private String subject;

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
