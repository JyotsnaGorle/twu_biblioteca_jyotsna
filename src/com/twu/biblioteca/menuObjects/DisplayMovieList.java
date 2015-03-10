package com.twu.biblioteca.menuObjects;

import com.twu.biblioteca.LibraryMember;
import com.twu.biblioteca.MovieLibrary;
import com.twu.biblioteca.inputOutputDevice.InputOutputManager;
import com.twu.biblioteca.menuObjects.IMenuItem;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class DisplayMovieList implements IMenuItem {
    private MovieLibrary movieLibrary;
    public DisplayMovieList(MovieLibrary movieLibrary) {
    this.movieLibrary = movieLibrary;
    }

    @Override
    public int executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) throws IOException {
        inputOutputManager.writeOutput(movieLibrary.display());
        return 0;
    }

    @Override
    public String displayMenuItem() {
        return "Display Movie List";
    }
}
