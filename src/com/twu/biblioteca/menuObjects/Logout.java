package com.twu.biblioteca.menuObjects;

import com.twu.biblioteca.LibraryMember;
import com.twu.biblioteca.inputOutputDevice.InputOutputManager;
import com.twu.biblioteca.menuObjects.IMenuItem;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class Logout implements IMenuItem {
    @Override
    public int executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) throws IOException {
    return 9;
    }

    @Override
    public String displayMenuItem() {
        return "Logout";
    }
}
