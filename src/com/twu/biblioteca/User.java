package com.twu.biblioteca;

/**
 * Created by jyotsna on 03/03/15.
 */
public class User {
    public String getCustId() {
        return custId;
    }

    public String getPassword() {
        return password;
    }

    String custId;
    String password;

    public String getuName() {
        return uName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    String uName;
    String emailId;
    String phoneNo;

    public User(String custId, String password,String uName,String emailId,String phoneNo) {
        this.custId = custId;
        this.password = password;
        this.uName = uName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }
}
