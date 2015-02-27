package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasItem;

public class CustomerTest{

    @Test
    public void isCustomerCheckoutSuccessful(){
        BibliotecaLibrary library = new BibliotecaLibrary();
        Customer customer = new Customer();
        Book book = library.checkout("1");
        Assert.assertThat(customer.borrowBook(book), hasItem(book));
    }

    @Test(expected = customerBookListEmptyException.class)
    public void isCustomerBookListEmptyOrNot(){
        Customer customer= new Customer();
        customer.displayMyBookList();
    }

    @Test
    public void isReturnSuccessful(){
        BibliotecaLibrary library = new BibliotecaLibrary();
        Book book = library.checkout("1");
        Customer customer= new Customer();
        customer.borrowBook(book);
        Book returnedBook = customer.returnBook("1");
        Assert.assertThat(customer.getMyBookList(), not(hasItem(returnedBook)));
    }


}