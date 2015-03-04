package com.twu.biblioteca;

/**
 * Created by jyotsna on 03/03/15.
 */
public class Admin {
    String adminId;
    String adminPwd;

    public Admin() {
        this.adminId ="admin";
        this.adminPwd="pwd";
    }

    public boolean adminLogin(String adminId, String adminPwd) {
        if(adminId.equals(this.adminId)&& adminPwd.equals(this.adminPwd))
            return true;
        return false;
    }
}
