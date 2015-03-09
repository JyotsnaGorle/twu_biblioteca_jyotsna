package com.twu.biblioteca;

/**
 * Created by jyotsna on 09/03/15.
 */
public class Display implements IMenuItem {

    private  BookLibrary bookLibrary;
    public Display(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) {
        bookLibrary.display();
    }

    @Override
    public String displayMenuItem() {
        return "Display Items";
    }
}
