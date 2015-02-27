package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 26/02/15.
 */
// this class is a master copy of all the books the library owns
public class BookList {

    List<Book> books = new ArrayList<Book>();

    BookList() {
        this.books = listOfBooks;
    }

     List<Book> listOfBooks = new ArrayList<Book>() {
        {
            add(Book.createBook(1, "book1", "author1", "2012"));
            add(Book.createBook(2, "book2", "author2", "2012"));
            add(Book.createBook(3, "book3", "author3", "2012"));
            add(Book.createBook(4, "book4", "author4", "2012"));
        }
    };
}
