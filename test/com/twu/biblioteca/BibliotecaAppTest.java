package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

/**
 * Created by jyotsna on 27/02/15.
 */
public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private IOforTest testIO;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;
    private LibraryMember libraryMember;

    @Before
    public void setUp() {
        testIO = new IOforTest();
        bookLibrary = new BookLibrary();
        movieLibrary = new MovieLibrary();

        bibliotecaApp = new BibliotecaApp(testIO, bookLibrary, movieLibrary);
        libraryMember = new LibraryMember("111-111","hello","jolly","jolly@gmial.com","9087676565");
    }

    @Test
    public void openBibliotecaApp() throws IOException {
        testIO.setWithUserInputs("111-111", "hello");
        BibliotecaApp bibliotecaAppSpy = spy(bibliotecaApp);
        doNothing().when(bibliotecaAppSpy).selectOption(any(LibraryMember.class),any(BookLibrary.class),any(MovieLibrary.class));

        bibliotecaAppSpy.startApp(bookLibrary, movieLibrary);

        String expected = "-------WELCOME TO BIBLIOTECA--------Enter UserIdEnter password";

        Assert.assertEquals(expected, testIO.consoleOutput());
    }

    @Test
    public void isInvalidChoice() throws IOException {

        testIO.setWithUserInputs("10","0");

        bibliotecaApp.selectOption(libraryMember, bookLibrary, movieLibrary);

        String expected ="0. Exit1. " +
                "Display Book List2. " +
                "Checkout Item3. Return Item4." +
                " Display my Book List5. Display Movie " +
                "List6. Checkout Movie 9. LogoutEnter " +
                "your choiceinvalid choice renter0. Exit1." +
                " Display Book List2. Checkout Item3. Return " +
                "Item4. Display my Book List5. Display Movie List6. " +
                "Checkout Movie 9. LogoutEnter your choice";
        Assert.assertEquals(testIO.consoleOutput(),expected);
    }
    @Test
    public void givenBookidIsInvalidForCheckout() {
        BookLibrary library = new BookLibrary();
        Assert.assertNull(library.find("7"));
    }

    @Test
    public void shouldCheckout() throws IOException {
        String userChoice ="2";
        String bookId = "1";
        testIO.setWithUserInputs(userChoice,bookId,"0");
        bibliotecaApp.selectOption(libraryMember,bookLibrary,movieLibrary);
        String expected = "0. Exit1. Display Book List2. " +
                "Checkout Item3. Return " +
                "Item4. Display my Book List5." +
                " Display Movie List6. Checkout Movie 9." +
                " LogoutEnter your choiceEnter Book Id to " +
                "checkoutSUCCESSFUL CHECKOUT! ENJOY THE BookKentBeck_TDD_byexample0. " +
                "Exit1. Display Book List2. Checkout Item3. Return Item4. Display my Book " +
                "List5. Display Movie List6. Checkout Movie 9. LogoutEnter your choice";
        Assert.assertEquals(expected,testIO.consoleOutput());

    }

    @Test(expected = InvalidItemException.class)
    public void shouldNotReturnWhenCustomerListIsEmpty() throws IOException{
        String userChoice ="3";
        String bookId="2";
        testIO.setWithUserInputs(userChoice,bookId);
        bibliotecaApp.selectOption(libraryMember,bookLibrary,movieLibrary);
    }

    @Test
    public void testIfBookReturnIsSuccessful() throws IOException {
        String userFirstChoice ="2";
        String bookIdToCheckout ="1";
        String userChoiceToReturn ="3";
        String bookIdToReturn ="1";
        testIO.setWithUserInputs(userFirstChoice,bookIdToCheckout,userChoiceToReturn,bookIdToReturn,"0");
        String regularMenu = "0. Exit1. Display Book " +
                "List2. Checkout Item3. Return Item4. " +
                "Display my Book List5. Display Movie List6." +
                " Checkout Movie 9. LogoutEnter your choice" ;
                String expected = regularMenu+"Enter Book Id to " +
                        "checkoutSUCCESSFUL CHECKOUT! ENJOY THE " +
                        "BookKentBeck_TDD_byexample"+regularMenu+"Enter Book " +
                        "IdTHANK YOU FOR RETURNING THE BOOK KentBeck_TDD_byexample\n"+regularMenu;
        bibliotecaApp.selectOption(libraryMember,bookLibrary,movieLibrary);
        Assert.assertEquals(expected,testIO.consoleOutput());
    }

//    @Test
//    public void checkMovieCheckout()throws IOException{
//        LibraryMember libraryMember = new LibraryMember();
//        String movieId="2";
//        testIO.setWithUserInputs(movieId);
//        bibliotecaApp.setiLibraryType(6, bookLibrary, movieLibrary);
//        bibliotecaApp.checkOutItem(libraryMember);
//        String expected = "Enter Item IdSUCCESSFUL CHECKOUT! ENJOY THE ITEM";
//        Assert.assertEquals(expected,testIO.consoleOutput());
//
//    }
//
//    @Test
//    public void shouldAddToBorrowedItemListOnCheckout() throws IOException {
//        BookLibrary bookLibrary = mock(BookLibrary.class);
//        MovieLibrary movieLibrary = mock(MovieLibrary.class);
//        bibliotecaApp = new BibliotecaApp(testIO, bookLibrary, movieLibrary);
//        String bookId ="1";
//        String movieId="2";
//        String userId="1";
//
//        Book bookBorrowed = new Book(bookId, "KentBeck_TDD_byexample", "KentBeck", "2012");
//        LibraryMember libraryMember = new LibraryMember();
//        libraryMember.getMyBookList().add(bookBorrowed);
//
//        when(bookLibrary.checkout(libraryMember,bookId)).thenReturn(bookBorrowed);
//        bibliotecaApp.addToBorrowRecord(bookBorrowed, userId);
//
//        Movie movieBorrowed = new Movie(movieId,"movi2","director","rating","year");
//        libraryMember.getMyMovieList().add(movieBorrowed);
//
//        when(movieLibrary.checkout(libraryMember,movieId)).thenReturn(movieBorrowed);
//        bibliotecaApp.addToBorrowRecord(movieBorrowed, userId);
//        Assert.assertEquals(2,bibliotecaApp.borrowedItems.size());
//    }


}

