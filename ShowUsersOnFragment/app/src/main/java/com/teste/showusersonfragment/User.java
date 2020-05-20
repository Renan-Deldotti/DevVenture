package com.teste.showusersonfragment;

public class User {

    private int id;
    private String name, nickName;

    public User(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }
}
