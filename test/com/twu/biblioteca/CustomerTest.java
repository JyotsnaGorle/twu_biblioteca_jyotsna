package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasItem;

public class CustomerTest{

    @Test
    public void isCustomerCheckoutSuccessful(){
        BookLibrary library = new BookLibrary();
        Customer customer = new Customer();
        Book book = library.checkout("1", customer);
        Assert.assertThat(customer.borrowBook(book), hasItem(book));
    }

    @Test(expected = InvalidBookException.class)
    public void isCustomerBookListEmptyOrNot(){
        Customer customer= new Customer();
        customer.displayMyBookList();
    }

    @Test
    public void isReturnSuccessful(){
        BookLibrary library = new BookLibrary();
        Customer customer= new Customer();
        library.checkout("1", customer);
        Book returnedBook = customer.returnBook("1");
        Assert.assertThat(customer.getMyBookList(), not(hasItem(returnedBook)));
    }


}