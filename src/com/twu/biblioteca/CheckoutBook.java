package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class CheckoutBook implements IMenuItem{
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
