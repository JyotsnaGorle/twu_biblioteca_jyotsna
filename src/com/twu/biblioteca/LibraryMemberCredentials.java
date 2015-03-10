package com.twu.biblioteca;

import com.twu.biblioteca.domainObjects.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 03/03/15.
 */
public class LibraryMemberCredentials {

    List<LibraryMember> users = new ArrayList<LibraryMember>();

    public LibraryMemberCredentials() {
        this.users = listofcustomers;
    }


    List<LibraryMember> listofcustomers = new ArrayList<LibraryMember>(){{
       add(new LibraryMember("111-111","hello","jolly","jolly@gmial.com","9087676565"));
       add(new LibraryMember("211-111","hello","jolly","jolly@gmial.com","9087676565"));
       add(new LibraryMember("311-111","hello","jolly","jolly@gmial.com","9087676565"));
    }};

    public LibraryMember getCustomer(String userId, String password) {
    for(LibraryMember each : users){
        if(each.getId().equals(userId) && each.getPassword().equals(password))
            return each;
    }
        return null;
    }


    public User getCustomer(String userId)
    {
        for(User each : users){
            if(each.getId().equals(userId))
                return each;
        }
        return null;
    }
}

