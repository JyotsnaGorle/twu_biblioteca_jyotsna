package com.twu.biblioteca;

/**
 * Created by jyotsna on 03/03/15.
 */
public class User {
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    String id;
    String password;


    public User(String custId, String password) {
        this.id = custId;
        this.password = password;
    }
}
