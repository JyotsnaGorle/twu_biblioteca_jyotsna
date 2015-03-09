package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class Quit implements IMenuItem {
    @Override
    public void executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) throws IOException {

    }

    @Override
    public String displayMenuItem() {
        return "Quit";
    }
}
