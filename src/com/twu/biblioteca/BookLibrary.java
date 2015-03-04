package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary implements ILibrary {
    BookLibrary() {
        BookList books = new BookList();
        booksInLibrary = books.listOfBooks;
    }

     List<Book> booksInLibrary = new ArrayList<Book>();

    @Override
    public Object find(String bookId) {
        for (Book each : booksInLibrary) {
            if (each.getBookId().equals(bookId)) {
                return each;
            }
        }
        return null;
    }

    @Override
    public void display() {
        for(Book each : booksInLibrary) {
            System.out.println("----------------------------------------------------");
            System.out.println(each.getBookId() + " \t\t   " + each.getTitle() + " \t\t    " + each.getAuthor() + " \t \t   " + each.getYearOfPublishing());
            System.out.println("----------------------------------------------------");
        }
    }

    @Override
    public Object checkout(LibraryMember libraryMember,String bookId) {
        Book book_available = (Book) find(bookId);
        if (book_available != null) {
            libraryMember.borrowBook(book_available);
            booksInLibrary.remove(book_available);
            return book_available;
        } else
            return null;
    }

    @Override
    public Book returnItem(LibraryMember libraryMember, String bookId)throws InvalidItemException {
        Book bookToBeReturned = libraryMember.returnBook(bookId);
        booksInLibrary.add(bookToBeReturned);
        return bookToBeReturned;
    }
}

