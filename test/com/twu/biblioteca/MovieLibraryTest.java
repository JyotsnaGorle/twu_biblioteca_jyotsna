package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

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
        LibraryMember libraryMember = new LibraryMember("111-111","hello","jolly","jolly@gmial.com","9087676565");
    Movie movie = movieLibrary.checkout(libraryMember, "1");
        Assert.assertThat(movieLibrary.getListOfMovies(),not(hasItem(movie)));
    }


}
