package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.internal.matchers.IsCollectionContaining.hasItem;

public class CustomerTest{

    @Test
    public void is_customer_entering_biblioteca(){
        Customer customer = new Customer();
        String expected = customer.openBiblioteca();
        Assert.assertEquals("welcome",expected);
    }

    @Test
    public void is_customer_checkout_successful(){
        BibliotecaLibrary biblioteca = new BibliotecaLibrary();
        Customer customer = new Customer();
        Book book = biblioteca.is_book_available(1);
        Assert.assertThat(customer.borrowBook(1), hasItem(book));
    }

    @Test(expected = customerBookListEmptyException.class)
    public void is_customer_book_list_empty_or_not(){
        Customer customer= new Customer();
        customer.displayMyBookList();
    }

    @Test
    public void is_return_successful(){
        Customer customer= new Customer();
        List<Book> myBookListAfterReturn = customer.returnBook(1);
        Assert.assertNotNull(myBookListAfterReturn);
    }


}