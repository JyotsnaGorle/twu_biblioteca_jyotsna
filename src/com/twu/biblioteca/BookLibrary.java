package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookLibrary implements ILibrary {
    BookLibrary() {
        BookList books = new BookList();
        booksCurrentlyInLibrary = books.listOfBooks;
    }
        HashMap<String,Book> borrowedBooks = new HashMap<String, Book>();
     List<Book> booksCurrentlyInLibrary = new ArrayList<Book>();

    @Override
    public Object find(String bookId) {
        for (Book each : booksCurrentlyInLibrary) {
            if (each.getBookId().equals(bookId)) {
                return each;
            }
        }
        return null;
    }

    @Override
    public void display() {
        for(Book each : booksCurrentlyInLibrary) {
            System.out.println("----------------------------------------------------");
            System.out.println(each.getBookId() + " \t\t   " + each.getTitle() + " \t\t    " + each.getAuthor() + " \t \t   " + each.getYearOfPublishing());
            System.out.println("----------------------------------------------------");
        }
    }

    @Override
    public Book checkout(LibraryMember libraryMember,String bookId) {
        Book book_available = (Book) find(bookId);
        if (book_available != null) {
            libraryMember.borrowBook(book_available);
            booksCurrentlyInLibrary.remove(book_available);
            borrowedBooks.put(libraryMember.getId(), book_available);
            return book_available;
        } else
            return null;
    }

    @Override
    public Book returnItem(LibraryMember libraryMember, String bookId)throws InvalidItemException {
        Book bookToBeReturned = libraryMember.returnBook(bookId);
        booksCurrentlyInLibrary.add(bookToBeReturned);
        borrowedBooks.remove(bookToBeReturned);
        return bookToBeReturned;
    }
}

