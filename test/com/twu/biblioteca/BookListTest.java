package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jyotsna on 25/02/15.
 */
public class BookListTest {
    @Test
    public void should_fetch_book_list(){
        String books_list = BookList.viewListOfAllLibraryBooks();
        String expected ="title author year";
        Assert.assertEquals(expected, books_list);
    }
}
