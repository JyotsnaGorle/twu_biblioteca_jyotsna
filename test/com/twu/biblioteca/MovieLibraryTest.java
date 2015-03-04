package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;

/**
 * Created by jyotsna on 02/03/15.
 */
public class MovieLibraryTest {

    private MovieLibrary movieLibrary;
    @Before
    public void setUp() {
    movieLibrary =new MovieLibrary();
    }

    @Test
    public void isMovieAvailable(){
        Assert.assertNotNull(movieLibrary.find("1"));
    }

    @Test
    public void isMovieCheckoutSuccessful(){
        LibraryMember libraryMember = new LibraryMember();
    Movie movie = (Movie)movieLibrary.checkout(libraryMember, "1");
        Assert.assertThat(movieLibrary.getListOfMovies(),hasItem(movie));
    }


}
