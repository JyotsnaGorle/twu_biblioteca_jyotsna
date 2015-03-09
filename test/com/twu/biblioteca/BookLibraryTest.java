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
        LibraryMember libraryMember = new LibraryMember("111-111","hello","jolly","jolly@gmial.com","9087676565");
        Assert.assertEquals(library.checkout(libraryMember,"1"),book);
    }


}