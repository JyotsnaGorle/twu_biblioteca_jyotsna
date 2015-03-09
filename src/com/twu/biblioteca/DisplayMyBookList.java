package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class DisplayMyBookList implements IMenuItem {
    private BookLibrary bookLibrary;

    public DisplayMyBookList(BookLibrary bookLibrary) {
    this.bookLibrary = bookLibrary;
    }

    @Override
    public int executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) throws IOException {
        try {
            libraryMember.displayMyItemList(bookLibrary);
        }catch (InvalidItemException e){
            inputOutputManager.writeOutput("Your Book List is empty");
        }

        return 0;
    }

    @Override
    public String displayMenuItem() {
        return "Display my Book List";
    }
}
