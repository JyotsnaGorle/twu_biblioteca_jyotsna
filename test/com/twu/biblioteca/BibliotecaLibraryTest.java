package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BibliotecaLibraryTest {


    @Test
    public void is_choice_1_viewing_list(){
        BibliotecaLibrary bibliotecaApp = new BibliotecaLibrary();
    String expected = "title author year";
        Assert.assertEquals(expected, bibliotecaApp.viewList());
    }

    @Test(expected = Invalid_choice_exception.class)
    public void is_customer_selecting_correct_option() throws IOException {
        BibliotecaLibrary biblioteca = new BibliotecaLibrary();
        biblioteca.selectOption(2);

    }
}