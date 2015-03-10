package com.twu.biblioteca;

/**
 * Created by jyotsna on 03/03/15.
 */
public class Admin extends User{


    public Admin() {
    super("admin","pwd");
    }

    public boolean adminLogin(String adminId, String adminPwd) {
        if(adminId.equals(this.getId())&& adminPwd.equals(this.getPassword()))
            return true;
        return false;
    }


}
