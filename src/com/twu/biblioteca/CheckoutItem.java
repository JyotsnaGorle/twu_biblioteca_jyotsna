package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class CheckoutItem implements IMenuItem{
    private BookLibrary bookLibrary;

    public CheckoutItem(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) throws IOException {
        inputOutputManager.writeOutput("Enter Item Id to checkout");
        String itemId = inputOutputManager.getInput();
        Book checkedBook = (Book) bookLibrary.checkout(libraryMember, itemId);
        if(checkedBook!=null){
            inputOutputManager.writeOutput("SUCCESSFUL CHECKOUT! ENJOY THE ITEM");
            libraryMember.borrowBook(checkedBook);


        }
        else {
            inputOutputManager.writeOutput("------This is an Invalid Item------");
        }

    }

    @Override
    public String displayMenuItem() {
        return "Checkout Item";
    }
}
