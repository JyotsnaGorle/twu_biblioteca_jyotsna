package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    BookLibrary() {
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

    public Book checkout(String bookId, Customer customer){
        Book book_available = find(bookId);
        if (book_available != null) {
            customer.borrowBook(book_available);
            booksInLibrary.remove(book_available);
            return book_available;
        } else
            return null;
    }


    public Book find(String bookId) {
        for (Book each : booksInLibrary) {
            if (each.getBookId().equals(bookId)) {
                return each;
            }
        }
            return null;
    }

    public Book returnBook(String bookId, Customer customer) throws InvalidBookException {
        Book bookToBeReturned = customer.returnBook(bookId);
        booksInLibrary.add(bookToBeReturned);
        return bookToBeReturned;
    }
}

