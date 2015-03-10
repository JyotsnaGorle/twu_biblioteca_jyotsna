package com.twu.biblioteca;

import com.twu.biblioteca.domainObjects.Book;

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
            add(Book.createBook("1", "KentBeck_TDD_byexample", "KentBeck", "2012"));
            add(Book.createBook("2", "The Kite Runner", "Khaleid Hoseni", "2003"));
            add(Book.createBook("3", "Harry Potter", "J.K.Rowling", "2000"));
            add(Book.createBook("4", "The Alchemist", "Paulo Cohelo", "1988"));
        }
    };
}
