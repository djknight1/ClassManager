package com.iloooo.bean;

public class Admin {
    private long Id;
    private String username;
    private String password;
    private String name;

    @Override
    public String toString() {
        return "Admin{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin(long id, String username, String password, String name) {

        Id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Admin() {

    }
}
