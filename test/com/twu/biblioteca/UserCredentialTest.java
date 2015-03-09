package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jyotsna on 03/03/15.
 */
public class UserCredentialTest {
    @Test
    public void isLoginSuccessful(){
        LibraryMemberCredentials libraryMemberCredentials = new LibraryMemberCredentials();
        String custId ="111-111";
        String password ="hello";
        Assert.assertNotNull(libraryMemberCredentials.getCustomer(custId,password));

    }
}
