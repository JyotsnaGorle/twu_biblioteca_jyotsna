package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public interface IMenuItem {
public void executeAction(LibraryMember libraryMember,InputOutputManager inputOutputManager) throws IOException;
public String displayMenuItem();
}
