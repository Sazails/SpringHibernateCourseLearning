package org.sazails.entity;

public class User {

    private int id;
    private String username;
    private String tag;

    public User() { }

    public User(int id, String username, String tag) {
        this.id = id;
        this.username = username;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
