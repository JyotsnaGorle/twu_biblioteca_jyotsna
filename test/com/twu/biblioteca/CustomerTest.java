package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CustomerTest{

    @Test
    public void is_customer_entering_biblioteca(){
        Customer customer = new Customer();
        String expected = customer.openBiblioteca();
        Assert.assertEquals("welcome",expected);
    }

    @Test(expected = Invalid_choice_exception.class)
    public void is_customer_selecting_correct_option() throws IOException {
        Customer customer = new Customer();
        customer.selectOption(2);
    }

    @Test
    public void is_customer_checkout_successful(){
        Customer customer = new Customer();
        String actual = customer.checkout();
        String expected = "successful checkout";
        Assert.assertEquals(expected,actual);
    }


}