package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaLibrary {

    BibliotecaLibrary(){
        booksInLibrary = BookList.libraryBookList;
    }
    // static becoz booksInLibrary can be accessed by any customer
    static List<Book> booksInLibrary = new ArrayList<Book>();

    public static String openApp() {
        return "welcome";
    }

    public void viewLibraryBookList() {
        for(Book each : booksInLibrary){
            System.out.println(each.getTitle()+" "+each.getTitle()+" "+each.getYearOfPublishing());
        }
    }

    public static Book checkout(String book_name) {
        if(is_book_available(book_name)!=null){
        for(Book each_book : booksInLibrary) {
                if(each_book.getTitle().equals(book_name)){
            booksInLibrary.remove(each_book);
                    return each_book;
                }
            }
        }
        else {
            System.out.println("Book not available");
        }
        return null;
        }



    public static Book is_book_available(String book_name) {
        for (Book each : booksInLibrary) {
            if (each.getTitle().equals(book_name)) {
                return each;
            }
        }
            return null;
        }


    public static void returnBook(Book bookToBeReturned) {
        booksInLibrary.add(bookToBeReturned);
    }
}

