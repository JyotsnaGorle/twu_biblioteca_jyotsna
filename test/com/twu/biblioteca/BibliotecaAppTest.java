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

    @Test
    public void shouldCheckoutMovie()throws IOException{
        String userFirstChoice ="6";
        String movieIdToCheckout="2";

        testIO.setWithUserInputs(userFirstChoice,movieIdToCheckout,"0");
        bibliotecaApp.selectOption(libraryMember,bookLibrary,movieLibrary);
        String regularMenu = "0. Exit1. Display Book " +
                "List2. Checkout Item3. Return Item4. " +
                "Display my Book List5. Display Movie List6." +
                " Checkout Movie 9. LogoutEnter your choice" ;

        String expected = regularMenu+"Enter Movie Id to checkoutSUCCESSFUL CHECKOUT! ENJOY THE Moviemovie2"+regularMenu;
        Assert.assertEquals(expected,testIO.consoleOutput());

    }


}

