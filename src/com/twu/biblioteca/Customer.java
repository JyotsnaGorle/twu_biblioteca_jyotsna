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

    public List<Book> getMyBookList() {
        return myBookList;
    }

    private List<Book> myBookList = new ArrayList<Book>();

    public int getChoice() throws IOException {
        return Integer.parseInt(read.readLine());
    }


    public List<Book> borrowBook(Book borrowedBook) {
        myBookList.add(borrowedBook);
        System.out.println("SUCCESSFUL CHECKOUT! ENJOY THE BOOK "+borrowedBook.getTitle());
        return myBookList;
    }

    public void displayMyBookList() {
        if (myBookList.isEmpty()) {
            throw new customerBookListEmptyException();
        } else {
            for (Book eachBook : myBookList) {
                System.out.println(eachBook.getBookId() + " \t\t   " + eachBook.getTitle() + " \t\t    " + eachBook.getAuthor() + " \t \t   " + eachBook.getYearOfPublishing());
            }
        }
    }

    public Book isBookWithMe(String bookId) {
        for (Book each : myBookList) {
            if (each.getBookId().equals(bookId))
                return each;
        }
        return null;
    }

    public Book returnBook(String bookId) {
        if (myBookList.isEmpty()) {
            throw new customerBookListEmptyException();
        }
        Book bookToBeReturned = isBookWithMe(bookId);
        if (bookToBeReturned != null) {
            myBookList.remove(bookToBeReturned);
            System.out.println("THANK YOU FOR RETURNING THE BOOK " + bookToBeReturned.getTitle() + "\n");
        }
        return bookToBeReturned;
    }

}
