package com.example.lab11consumer;

public class Friends {
    String user;
    String friend;

    public Friends(String user, String friend) {
        this.user = user;
        this.friend = friend;
    }

    public Friends() {}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }
}
