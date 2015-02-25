package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class BibliotecaAppTest{

    @Test
    public void is_choice_1_viewing_list(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
    String expected = "title author year";
        Assert.assertEquals(expected, bibliotecaApp.viewList());
    }
}