package com.twu.biblioteca.menuObjects;

import com.twu.biblioteca.LibraryMember;
import com.twu.biblioteca.MovieLibrary;
import com.twu.biblioteca.domainObjects.Movie;
import com.twu.biblioteca.inputOutputDevice.InputOutputManager;
import com.twu.biblioteca.menuObjects.IMenuItem;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class CheckoutMovie implements IMenuItem {
    private MovieLibrary movieLibrary;
    public CheckoutMovie(MovieLibrary movieLibrary) {
    this.movieLibrary =movieLibrary;
    }

    @Override
    public int executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) throws IOException {

        inputOutputManager.writeOutput("Enter Movie Id to checkout");
        String itemId = inputOutputManager.getInput();
        Movie checkedMovie = movieLibrary.checkout(libraryMember, itemId);
        if(checkedMovie!=null){
            inputOutputManager.writeOutput("SUCCESSFUL CHECKOUT! ENJOY THE Movie" + checkedMovie.getTitle());
            libraryMember.borrowMovie(checkedMovie);



        }
        else {
            inputOutputManager.writeOutput("------This is an Invalid Item------");
        }
        return 0;
    }

    @Override
    public String displayMenuItem() {
        return "Checkout Movie ";
    }
}
