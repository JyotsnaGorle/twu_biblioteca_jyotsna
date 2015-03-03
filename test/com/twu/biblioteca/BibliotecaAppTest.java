package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jyotsna on 27/02/15.
 */
public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private IOforTest testIO;

    @Before
    public void setUp() {
        testIO = new IOforTest();
        bibliotecaApp = new BibliotecaApp(testIO);
    }

    @Test
    public void openBibliotecaApp() {
        bibliotecaApp.startApp();
        String expected = "-------WELCOME TO BIBLIOTECA--------";

        Assert.assertEquals(testIO.consoleOutput(), expected);
    }

    @Test
    public void isOptionAvailable() throws IOException {
        Customer customer = new Customer();

        int customer_choice = 7;
        bibliotecaApp.selectOption(customer, customer_choice);

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
        Customer customer = new Customer();
        String input = "1";
        testIO.withUserInputs(input);
        bibliotecaApp.checkOutItem(customer);
        String expected = "Enter Book IdSUCCESSFUL CHECKOUT! ENJOY THE ITEM";
        Assert.assertEquals(expected,testIO.consoleOutput());

    }

    @Test
    public void checkOption3WhenCustomerListIsEmpty() throws IOException{
        Customer customer = new Customer();
        String bookId="2";
        testIO.withUserInputs(bookId);

        bibliotecaApp.returnBook(customer);
        String expected ="---------your book list is empty---------";
        Assert.assertEquals(expected,testIO.consoleOutput());
    }

    @Test
    public void testIfBookReturnIsSuccessful() throws IOException {
        BookLibrary bookLibraryMock = mock(BookLibrary.class);
        bibliotecaApp = new BibliotecaApp(testIO);

        String bookId = "1";
        Book bookBorrowed = new Book(bookId, "KentBeck_TDD_byexample", "KentBeck", "2012");
        Customer customer = new Customer();
        customer.getMyBookList().add(bookBorrowed);

        when(bookLibraryMock.returnBook(bookId, customer)).thenReturn(bookBorrowed);
        testIO.withUserInputs(bookId);

        bibliotecaApp.returnBook(customer);

        String expected = "Enter Book IdTHANK YOU FOR RETURNING THE BOOK KentBeck_TDD_byexample\n";
        Assert.assertEquals(expected,testIO.consoleOutput());
    }



}

