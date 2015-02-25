package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest{

    @Test
    public void is_customer_entering_biblioteca(){
        Customer customer = new Customer();
        String expected = customer.openBiblioteca();
        Assert.assertEquals("welcome",expected);
    }



    @Test
    public void is_customer_checkout_successful(){
        Customer customer = new Customer();
        Assert.assertNotNull(customer.borrowBook("book1"));
    }


}