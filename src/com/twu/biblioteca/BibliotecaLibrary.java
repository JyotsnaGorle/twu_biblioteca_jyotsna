package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaLibrary {
    BibliotecaLibrary() {
        BookList books = new BookList();
        booksInLibrary = books.listOfBooks;
    }

     List<Book> booksInLibrary = new ArrayList<Book>();


    public void viewLibraryBookList() {
                for(Book each : booksInLibrary) {
            System.out.println("----------------------------------------------------");
            System.out.println(each.getBookId() + " \t\t   " + each.getTitle() + " \t\t    " + each.getAuthor() + " \t \t   " + each.getYearOfPublishing());
            System.out.println("----------------------------------------------------");
        }
    }

    public Book checkout(String bookId){
        Book book_available = isBookAvailable(bookId);
        if (book_available != null) {
            booksInLibrary.remove(book_available);
            return book_available;
        } else
            return null;
    }


    public Book isBookAvailable(String bookId) {
        for (Book each : booksInLibrary) {
            if (each.getBookId().equals(bookId)) {
                return each;
            }
        }
            return null;
    }


    public void returnBook(Book bookToBeReturned) {
        booksInLibrary.add(bookToBeReturned);
    }
}

