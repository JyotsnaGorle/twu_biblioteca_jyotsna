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
            System.out.println(each.getBookId()+" \t\t   "+each.getTitle()+" \t\t    "+each.getAuthor()+" \t \t   "+each.getYearOfPublishing());
        }
    }

    public static Book checkout(int bookId) {
        if(is_book_available(bookId)!=null){
        for(Book each_book : booksInLibrary) {
                if(each_book.getBookId()==bookId){
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



    public static Book is_book_available(int bookId) {
        for (Book each : booksInLibrary) {
            if (each.getBookId()==bookId) {
                return each;
            }
        }
            return null;
        }


    public static void returnBook(Book bookToBeReturned) {
        booksInLibrary.add(bookToBeReturned);
    }
}

