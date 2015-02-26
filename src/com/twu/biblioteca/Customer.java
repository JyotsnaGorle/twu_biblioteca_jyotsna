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
    //non static becoz each customer will have his own book list
      List<Book> myBookList = new ArrayList<Book>();
    public String openBiblioteca() {
    return BibliotecaLibrary.openApp();
    }

    public int getChoice() throws IOException {
        return Integer.parseInt(read.readLine());
    }


    public List<Book> borrowBook(int bookId) {
        Book checkedBook = BibliotecaLibrary.checkout(bookId);
        myBookList.add(checkedBook);
        System.out.println("successful checkout");
        handleDisplayMyBookList();
        return myBookList;
    }

    public void displayMyBookList() {
        if(myBookList.isEmpty()){
            throw new customerBookListEmptyException();
        }
        else {
            for(Book eachBook :myBookList)
                System.out.println(eachBook.getBookId()+" \t\t   "+eachBook.getTitle()+" \t\t    "+eachBook.getAuthor()+" \t \t   "+eachBook.getYearOfPublishing());
        }
    }

    public Book isBookWithMe(int bookId) {
        for(Book each: myBookList){
            if(each.getBookId()==bookId)
                return each;
        }
        return null;
    }

    public List<Book> returnBook(int bookId) {
        Book bookToBeReturned = isBookWithMe(bookId);
        if(bookToBeReturned!=null){
            BibliotecaLibrary.returnBook(bookToBeReturned);
            myBookList.remove(bookToBeReturned);
            System.out.println("Successful return\n");
            handleDisplayMyBookList();
        }
        return myBookList;
    }

    private void handleDisplayMyBookList() {
        try {
            System.out.println("My books List");
            System.out.println("Book ID   Book Title    Author Name   Year Published");
            displayMyBookList();
        } catch (customerBookListEmptyException e) {
            System.out.println("your book list is empty\n");
        }
    }

}
