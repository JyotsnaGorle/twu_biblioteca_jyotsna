package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class Exit implements IMenuItem {
    @Override
    public int executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) throws IOException {
        return 1;
    }

    @Override
    public String displayMenuItem() {
        return "Exit";
    }
}
