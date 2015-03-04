package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jyotsna on 03/03/15.
 */
public class UserCredentialTest {
    @Test
    public void isLoginSuccessful(){
        UserCredentials userCredentials = new UserCredentials();
        String custId ="1";
        String password ="hello";
        Assert.assertNotNull(userCredentials.getCustomer(custId,password));

    }
}
