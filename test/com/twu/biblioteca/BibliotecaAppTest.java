package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jyotsna on 27/02/15.
 */
public class BibliotecaAppTest {

    @Test
    public void openBibliotecaApp(){
        IOforTest testIO = new IOforTest();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(testIO);
        bibliotecaApp.startApp();
        String expected = "WELCOME TO BIBLIOTECA";

        Assert.assertEquals(testIO.consoleOutput(), expected);
    }
@Test
    public void givenBookidIsInvalid(){
    BibliotecaLibrary library = new BibliotecaLibrary();
    Assert.assertNull(library.isBookAvailable("7"));
}

}

