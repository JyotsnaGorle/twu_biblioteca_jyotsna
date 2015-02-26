package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;

public class CustomerTest{

    @Test
    public void is_customer_checkout_successful(){
        BibliotecaLibrary biblioteca = new BibliotecaLibrary();
        Customer customer = new Customer();
        Book book = biblioteca.checkout(1);
        Assert.assertThat(customer.borrowBook(book), hasItem(book));
    }

    @Test(expected = customerBookListEmptyException.class)
    public void is_customer_book_list_empty_or_not(){
        Customer customer= new Customer();
        customer.displayMyBookList();
    }

    @Test
    public void is_return_successful(){
        BibliotecaLibrary biblioteca = new BibliotecaLibrary();
        Book book = biblioteca.checkout(1);
        Customer customer= new Customer();
        customer.borrowBook(book);
        Book returnedBook = customer.returnBook(1);
        Assert.assertThat(customer.getMyBookList(), not(hasItem(returnedBook)));
    }


}