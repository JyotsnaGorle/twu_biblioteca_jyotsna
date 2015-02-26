package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 25/02/15.
 */

public class Customer {
BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     private List<Book> myBookList = new ArrayList<Book>();
    public String openBiblioteca() {
    return BibliotecaLibrary.openApp();
    }

    public int getChoice() throws IOException {
        return Integer.parseInt(read.readLine());
    }


    public List<Book> borrowBook(String book_name) {
        Book checkedBook = BibliotecaLibrary.checkout(book_name);
        myBookList.add(checkedBook);
        System.out.println("successful checkout");
        return getMyBookList();
    }


    public void displayMyBookList() {
        if(getMyBookList().isEmpty()){
            throw new customerBookListEmptyException();
        }
        else {
            for(Book eachBook : getMyBookList())
                System.out.println(eachBook.getTitle()+" "+eachBook.getAuthor()+eachBook.getYearOfPublishing());
        }
    }

    public Book isBookWithMe(String bookName) {
        for(Book each: getMyBookList()){
            if(each.getTitle().equals(bookName))
                return each;
        }
        return null;
    }


    public List<Book> getMyBookList() {
        return myBookList;
    }


    public List<Book> returnBook(String bookName) {
        Book bookToBeReturned = isBookWithMe(bookName);
        if(bookToBeReturned!=null){
            myBookList.remove(bookToBeReturned);
        }
        return myBookList;
    }
}
