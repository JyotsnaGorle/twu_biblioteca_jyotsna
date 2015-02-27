package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by jyotsna on 27/02/15.
 */
public class BibliotecaAppTest {

    @Test
    public void openBibliotecaApp() {
        IOforTest testIO = new IOforTest();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(testIO);
        bibliotecaApp.startApp();
        String expected = "-------WELCOME TO BIBLIOTECA--------";

        Assert.assertEquals(testIO.consoleOutput(), expected);
    }

    @Test
    public void isOptionAvailable() throws IOException {
        IOforTest testIO = new IOforTest();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(testIO);
        BibliotecaLibrary library = new BibliotecaLibrary();
        Customer customer = new Customer();

        int customer_choice = 7;
        bibliotecaApp.selectOption(library,customer,customer_choice);

        String excpected ="Oops! invalid choice,please Renter";
        Assert.assertEquals(testIO.consoleOutput(),excpected);
    }
    @Test
    public void givenBookidIsInvalidForCheckout() {
        BibliotecaLibrary library = new BibliotecaLibrary();
        Assert.assertNull(library.isBookAvailable("7"));
    }

}

