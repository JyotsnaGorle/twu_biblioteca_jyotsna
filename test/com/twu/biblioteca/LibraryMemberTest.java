package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasItem;

public class LibraryMemberTest {

    @Test
    public void isCustomerCheckoutSuccessful(){
        BookLibrary library = new BookLibrary();
        LibraryMember libraryMember = new LibraryMember();
        Book book = (Book)library.checkout(libraryMember,"1");
        Assert.assertThat(libraryMember.borrowBook(book), hasItem(book));
    }

    @Test(expected = InvalidItemException.class)
    public void isCustomerBookListEmptyOrNot(){
        LibraryMember libraryMember = new LibraryMember();
        ILibrary iLibrary = new BookLibrary();
        libraryMember.displayMyItemList(iLibrary);
    }

    @Test
    public void isReturnSuccessful(){
        BookLibrary library = new BookLibrary();
        LibraryMember libraryMember = new LibraryMember();
        library.checkout(libraryMember,"1");
        Book returnedBook = libraryMember.returnBook("1");
        Assert.assertThat(libraryMember.getMyBookList(), not(hasItem(returnedBook)));
    }
    @Test
    public void isMovieBorrowedSuccessfuly(){
        LibraryMember libraryMember = new LibraryMember();
        MovieLibrary movieLibrary = new MovieLibrary();
        Movie borrowedMovie = movieLibrary.checkout(libraryMember,"1");
        Assert.assertThat(libraryMember.borrowMovie(borrowedMovie),hasItem(borrowedMovie));
    }


}