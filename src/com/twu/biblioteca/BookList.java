package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 26/02/15.
 */
// this class is a master copy of all the books the library owns
public class BookList {
    List<Book> booksOfLibrary = new ArrayList<Book>();
    BookList(){
        this.booksOfLibrary = libraryBookList;
    }
    static List<Book> libraryBookList = new ArrayList<Book>(){{
        add(Book.createBook("book1","author1","2012"));
        add(Book.createBook("book2","author2","2012"));
        add(Book.createBook("book3","author3","2012"));
        add(Book.createBook("book4", "author4", "2012"));
    }
    };
}
