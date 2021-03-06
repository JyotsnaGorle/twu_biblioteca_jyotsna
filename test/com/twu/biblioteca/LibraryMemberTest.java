package com.twu.biblioteca;

import com.twu.biblioteca.domainObjects.Book;
import com.twu.biblioteca.domainObjects.Movie;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasItem;

public class LibraryMemberTest {

    @Test
    public void isCustomerCheckoutSuccessful(){
        BookLibrary library = new BookLibrary();
        LibraryMember libraryMember = new LibraryMember("111-111","hello","jolly","jolly@gmial.com","9087676565");
        Book book = (Book)library.checkout(libraryMember,"1");
        Assert.assertThat(libraryMember.borrowBook(book), hasItem(book));
    }

    @Test(expected = InvalidItemException.class)
    public void isCustomerBookListEmptyOrNot(){
        LibraryMember libraryMember = new LibraryMember("111-111","hello","jolly","jolly@gmial.com","9087676565");
        ILibrary iLibrary = new BookLibrary();
        libraryMember.displayMyItemList(iLibrary);
    }

    @Test
    public void isReturnSuccessful(){
        BookLibrary library = new BookLibrary();
        LibraryMember libraryMember = new LibraryMember("111-111","hello","jolly","jolly@gmial.com","9087676565");
        library.checkout(libraryMember,"1");
        Book returnedBook = libraryMember.returnBook("1");
        Assert.assertThat(libraryMember.getMyBookList(), not(hasItem(returnedBook)));
    }
    @Test
    public void isMovieBorrowedSuccessfuly(){
        LibraryMember libraryMember = new LibraryMember("111-111","hello","jolly","jolly@gmial.com","9087676565");
        MovieLibrary movieLibrary = new MovieLibrary();
        Movie borrowedMovie = movieLibrary.checkout(libraryMember,"1");
        Assert.assertThat(libraryMember.borrowMovie(borrowedMovie),hasItem(borrowedMovie));
    }


}