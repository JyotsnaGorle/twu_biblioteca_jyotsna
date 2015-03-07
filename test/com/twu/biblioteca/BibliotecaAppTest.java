package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Created by jyotsna on 27/02/15.
 */
public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private IOforTest testIO;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;

    @Before
    public void setUp() {
        testIO = new IOforTest();
        bibliotecaApp = new BibliotecaApp(testIO);
        bookLibrary = new BookLibrary();
        movieLibrary = new MovieLibrary();
    }

    @Test
    public void openBibliotecaApp() throws IOException {
        testIO.setWithUserInputs("111-111", "hello");
        BibliotecaApp bibliotecaAppSpy = spy(bibliotecaApp);
        doNothing().when(bibliotecaAppSpy).displayMenu(any(LibraryMember.class),any(BookLibrary.class),any(MovieLibrary.class));

        bibliotecaAppSpy.startApp();
        String expected = "-------WELCOME TO BIBLIOTECA--------Enter UserIdEnter password";

        Assert.assertEquals(expected, testIO.consoleOutput());
    }

    @Test
    public void isOptionAvailable() throws IOException {
        LibraryMember libraryMember = new LibraryMember();

        int customer_choice = 10;
        bibliotecaApp.selectOption(libraryMember, customer_choice);

        String excpected ="Oops! invalid choice,please Renter";
        Assert.assertEquals(testIO.consoleOutput(),excpected);
    }
    @Test
    public void givenBookidIsInvalidForCheckout() {
        BookLibrary library = new BookLibrary();
        Assert.assertNull(library.find("7"));
    }

    @Test
    public void checkOption2() throws IOException {
        LibraryMember libraryMember = new LibraryMember();
        String itemId = "1";
        testIO.setWithUserInputs(itemId);
        bibliotecaApp.setiLibraryType(2, bookLibrary, movieLibrary);
        bibliotecaApp.checkOutItem(libraryMember);
        String expected = "Enter Item IdSUCCESSFUL CHECKOUT! ENJOY THE ITEM";
        Assert.assertEquals(expected,testIO.consoleOutput());

    }

    @Test
    public void checkOption3WhenCustomerListIsEmpty() throws IOException{
        LibraryMember libraryMember = new LibraryMember();
        String bookId="2";
        testIO.setWithUserInputs(bookId);
        bibliotecaApp.setiLibraryType(3, bookLibrary, movieLibrary);
        bibliotecaApp.returnBook(libraryMember);
        String expected ="---------your book list is empty---------";
        Assert.assertEquals(expected,testIO.consoleOutput());
    }

    @Test
    public void testIfBookReturnIsSuccessful() throws IOException {
        BookLibrary bookLibraryMock = mock(BookLibrary.class);
        bibliotecaApp = new BibliotecaApp(testIO);
        bibliotecaApp.setiLibraryType(3, bookLibrary, movieLibrary);
        String bookId = "1";
        Book bookBorrowed = new Book(bookId, "KentBeck_TDD_byexample", "KentBeck", "2012");
        LibraryMember libraryMember = new LibraryMember();
        libraryMember.getMyBookList().add(bookBorrowed);

        when(bookLibraryMock.returnItem(libraryMember, bookId)).thenReturn(bookBorrowed);
        testIO.setWithUserInputs(bookId);

        bibliotecaApp.returnBook(libraryMember);

        String expected = "Enter Book IdTHANK YOU FOR RETURNING THE BOOK KentBeck_TDD_byexample\n";
        Assert.assertEquals(expected,testIO.consoleOutput());
    }

    @Test
    public void checkMovieCheckout()throws IOException{
        LibraryMember libraryMember = new LibraryMember();
        String movieId="2";
        testIO.setWithUserInputs(movieId);
        bibliotecaApp.setiLibraryType(6, bookLibrary, movieLibrary);
        bibliotecaApp.checkOutItem(libraryMember);
        String expected = "Enter Item IdSUCCESSFUL CHECKOUT! ENJOY THE ITEM";
        Assert.assertEquals(expected,testIO.consoleOutput());

    }

    @Test
    public void shouldAddToBorrowedItemListOnCheckout() throws IOException {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        bibliotecaApp = new BibliotecaApp(testIO);
        String bookId ="1";
        String movieId="2";
        String userId="1";

        Book bookBorrowed = new Book(bookId, "KentBeck_TDD_byexample", "KentBeck", "2012");
        LibraryMember libraryMember = new LibraryMember();
        libraryMember.getMyBookList().add(bookBorrowed);

        when(bookLibrary.checkout(libraryMember,bookId)).thenReturn(bookBorrowed);
        bibliotecaApp.addToBorrowRecord(bookBorrowed, userId);

        Movie movieBorrowed = new Movie(movieId,"movi2","director","rating","year");
        libraryMember.getMyMovieList().add(movieBorrowed);

        when(movieLibrary.checkout(libraryMember,movieId)).thenReturn(movieBorrowed);
        bibliotecaApp.addToBorrowRecord(movieBorrowed, userId);
        Assert.assertEquals(2,bibliotecaApp.borrowedItems.size());
    }


}

