package com.twu.biblioteca.menuObjects;

import com.twu.biblioteca.BookLibrary;
import com.twu.biblioteca.LibraryMember;
import com.twu.biblioteca.domainObjects.Book;
import com.twu.biblioteca.inputOutputDevice.InputOutputManager;
import com.twu.biblioteca.menuObjects.IMenuItem;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class CheckoutBook implements IMenuItem {
    private BookLibrary bookLibrary;

    public CheckoutBook(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    @Override
    public int executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) throws IOException {
        inputOutputManager.writeOutput("Enter Book Id to checkout");
        String bookId = inputOutputManager.getInput();
        Book checkedBook = bookLibrary.checkout(libraryMember, bookId);
        if(checkedBook!=null){
            inputOutputManager.writeOutput("SUCCESSFUL CHECKOUT! ENJOY THE Book"+ checkedBook.getTitle());
            libraryMember.borrowBook(checkedBook);
        }
        else {
            inputOutputManager.writeOutput("------This is an Invalid Item------");
        }
return 0;
    }

    @Override
    public String displayMenuItem() {
        return "Checkout Item";
    }
}
