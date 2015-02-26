package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

public class LibraryManagerTest {
    @Test(expected = Invalid_choice_exception.class)
    public void is_option_available() throws IOException {
        LibraryManager manager = new LibraryManager();
        Customer customer = new Customer();
        manager.selectOption(customer, 6);

    }


}