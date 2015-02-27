package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaLibrary {
    BibliotecaLibrary() {
        BookList books = new BookList();
        booksInLibrary = books.listOfBooks;
    }

     List<Book> booksInLibrary = new ArrayList<Book>();

    public String openApp() {
        return "welcome";
    }

    public void viewLibraryBookList() {
                for(Book each : booksInLibrary) {
            System.out.println(each.getBookId() + " \t\t   " + each.getTitle() + " \t\t    " + each.getAuthor() + " \t \t   " + each.getYearOfPublishing());
        }
    }

    public Book checkout(int bookId){
        Book book_available = is_book_available(bookId);
        if (book_available != null) {
//        for(Book each_book : booksInLibrary) {
//                if(each_book.getBookId()==bookId){
//            booksInLibrary.remove(each_book);
//                    return each_book;
//                }
//            }
            booksInLibrary.remove(book_available);
            return book_available;
        } else
            return null;
    }


    public Book is_book_available(int bookId) {
//        for (Book each : booksInLibrary) {
//            if (each.getBookId()==bookId) {
//                return each;
//            }
//        }
//            return null;
        for (int i = 0; i < booksInLibrary.size(); i++) {
            if (booksInLibrary.get(i).getBookId() == bookId)
                return booksInLibrary.get(i);
        }
        return null;
    }


    public void returnBook(Book bookToBeReturned) {
        booksInLibrary.add(bookToBeReturned);
        viewLibraryBookList();
    }
}

