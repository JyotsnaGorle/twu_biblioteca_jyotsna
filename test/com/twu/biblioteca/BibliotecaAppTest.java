package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jyotsna on 27/02/15.
 */
public class BibliotecaAppTest {
@Test
    public void given_BookId_is_Invalid(){
    BibliotecaLibrary biblioteca = new BibliotecaLibrary();
    Assert.assertNull(biblioteca.is_book_available("7"));
}

}

