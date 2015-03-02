package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class BookLibraryTest {

    @Test
    public void isBookAvailable(){
        BookLibrary library = new BookLibrary();
        Assert.assertNotNull(library.find("1"));
    }
    @Test
    public void isBookCheckedOutFromBibliotecaLibrary(){
        BookLibrary library = new BookLibrary();
        Book book = (Book)library.find("1");
        Customer customer = new Customer();
        Assert.assertEquals((Book)library.checkout(customer,"1"),book);
    }


}