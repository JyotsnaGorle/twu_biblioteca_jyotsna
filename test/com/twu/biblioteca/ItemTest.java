package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jyotsna on 04/03/15.
 */
public class ItemTest {
    @Test
    public void shouldShowItemInfoForBook(){
        Book borrowedBook = new Book("1dummy","titleDummy","authorDummy","yearDummy");
        String userId ="1";
        Item bookItem = new Item(borrowedBook,userId);
        String expected = "1dummy  titleDummy  authorDummy  yearDummy  1";
        Assert.assertEquals(expected,bookItem.getItemInfo());
    }

    @Test
    public void shouldShowItemInfoForMovie(){
        Movie borrowedMovie = new Movie("1dummy","titleDummy","director","ratingDummy","yearOfrelease");
        String userId ="2";
        Item movieItem = new Item(borrowedMovie,userId);
        String expected = "1dummy  titleDummy  director  ratingDummy  yearOfrelease  2";
        Assert.assertEquals(expected,movieItem.getItemInfo());
    }
}
