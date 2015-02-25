package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;


import static org.hamcrest.core.IsNot.not;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;

public class BibliotecaLibraryTest {

    @Test
    public void is_book_available(){
        BibliotecaLibrary biblioteca = new BibliotecaLibrary();
        String bookName="book1";
        Assert.assertNotNull(biblioteca.is_book_available(bookName));
    }
    @Test
    public void is_book_checked_out_from_biblioteca_library(){
        BibliotecaLibrary biblioteca = new BibliotecaLibrary();
        Book book = biblioteca.is_book_available("book1");
        Assert.assertThat(biblioteca.checkout("book1"),not(hasItem(book)));
    }

    @Test(expected = Customer_book_list_is_empty_exception.class)
    public void is_customer_book_list_empty_or_not(){
        BibliotecaLibrary biblioteca = new BibliotecaLibrary();
    }


}