package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jyotsna on 03/03/15.
 */
public class AdminTest {
    @Test
    public void checkAdminCredentials(){
        Admin admin = new Admin();
        String adminId="admin";
        String adminPwd="pwd";
        Assert.assertTrue(admin.adminLogin(adminId, adminPwd));
    }

}
