package com.example.gittestdemo;

public class Post {

    private String username;
    private String content;

    public Post(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;

    }
}
