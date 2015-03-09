package com.twu.biblioteca;

/**
 * Created by jyotsna on 09/03/15.
 */
public class DisplayBookList implements IMenuItem {

    private  BookLibrary bookLibrary;
    public DisplayBookList(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    @Override
    public int executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) {
        bookLibrary.display();
        return 0;
    }

    @Override
    public String displayMenuItem() {
        return "Display Book List";
    }
}
