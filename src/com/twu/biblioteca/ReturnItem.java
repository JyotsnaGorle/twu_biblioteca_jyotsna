package com.twu.biblioteca;

import com.twu.biblioteca.domainObjects.Book;
import com.twu.biblioteca.inputOutputDevice.InputOutputManager;
import com.twu.biblioteca.menuObjects.IMenuItem;

import java.io.IOException;

/**
 * Created by jyotsna on 09/03/15.
 */
public class ReturnItem implements IMenuItem {
    private BookLibrary bookLibrary;
    public ReturnItem(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    @Override
    public int executeAction(LibraryMember libraryMember, InputOutputManager inputOutputManager) throws IOException {
        if(libraryMember.getMyBookList().isEmpty()){
            inputOutputManager.writeOutput("---------your book list is empty---------");
        }
        inputOutputManager.writeOutput("Enter Book Id");
        String bookId = inputOutputManager.getInput();
        Book returnedBook = bookLibrary.returnItem(libraryMember,bookId);
        if(returnedBook!=null){
            inputOutputManager.writeOutput("THANK YOU FOR RETURNING THE BOOK " + returnedBook.getTitle() + "\n");
        }
        else {
            inputOutputManager.writeOutput("YOU DON'T HAVE THIS BOOK");
        }
return 0;
    }

    @Override
    public String displayMenuItem() {
        return "Return Item";
    }
}
