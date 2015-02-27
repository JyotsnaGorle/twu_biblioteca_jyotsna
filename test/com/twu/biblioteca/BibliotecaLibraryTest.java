package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class BibliotecaLibraryTest {

    @Test
    public void isBookAvailable(){
        BibliotecaLibrary library = new BibliotecaLibrary();
        Assert.assertNotNull(library.isBookAvailable("1"));
    }
    @Test
    public void isBookCheckedOutFromBibliotecaLibrary(){
        BibliotecaLibrary library = new BibliotecaLibrary();
        Book book = library.isBookAvailable("1");
        Assert.assertEquals(library.checkout("1"),book);
    }


}