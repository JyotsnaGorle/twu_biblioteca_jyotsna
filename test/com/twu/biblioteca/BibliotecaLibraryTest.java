package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class BibliotecaLibraryTest {

    @Test
    public void is_book_available(){
        BibliotecaLibrary biblioteca = new BibliotecaLibrary();
        Assert.assertNotNull(biblioteca.is_book_available("1"));
    }
    @Test
    public void is_book_checked_out_from_biblioteca_library(){
        BibliotecaLibrary biblioteca = new BibliotecaLibrary();
        Book book = biblioteca.is_book_available("1");
        Assert.assertEquals(biblioteca.checkout("1"),book);
    }


}