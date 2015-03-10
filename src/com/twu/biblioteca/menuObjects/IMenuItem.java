package com.twu.biblioteca.menuObjects;

import com.twu.biblioteca.LibraryMember;
import com.twu.biblioteca.inputOutputDevice.InputOutputManager;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public interface IMenuItem {
public int executeAction(LibraryMember libraryMember,InputOutputManager inputOutputManager) throws IOException;
public String displayMenuItem();
}
