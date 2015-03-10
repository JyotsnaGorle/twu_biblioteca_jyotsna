package com.twu.biblioteca.domainObjects;

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


    public User(String userId, String password) {
        this.id = userId;
        this.password = password;
    }
}
