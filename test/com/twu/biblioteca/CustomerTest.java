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

    @Test(expected = customerBookListEmptyException.class)
    public void is_customer_book_list_empty_or_not(){
        Customer customer= new Customer();
        customer.displayMyBookList();
    }

//    @Test
//    public void is_book_with_customer(){
//        Customer customer = new Customer();
//        Assert.assertNotNull(customer.isBookWithMe("book1"));
//    }

//    @Test
//    public void is_return_successful(){
//        Customer customer= new Customer();
//        customer.returnBook("book1");
//    }


}