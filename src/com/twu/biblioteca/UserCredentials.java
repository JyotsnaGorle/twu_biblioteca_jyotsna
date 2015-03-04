package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 03/03/15.
 */
public class UserCredentials {

    List<User> users = new ArrayList<User>();

    public UserCredentials() {
        this.users = listofcustomers;
    }


    List<User> listofcustomers = new ArrayList<User>(){{
       add(new User("111-111","hello","jolly","jolly@gmial.com","9087676565"));
       add(new User("222-222","bello","adsjolly","jolly@gmial.com","9087676565"));
       add(new User("333-333","cello","jollsdy","jolly@gmial.com","9087676565"));
    }};

    public User getCustomer(String userId, String password) {
    for(User each : users){
        if(each.getCustId().equals(userId) && each.getPassword().equals(password))
            return each;
    }
        return null;
    }


    public User getCustomer(String userId)
    {
        for(User each : users){
            if(each.getCustId().equals(userId))
                return each;
        }
        return null;
    }
}

