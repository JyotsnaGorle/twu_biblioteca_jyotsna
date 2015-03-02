package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 25/02/15.
 */

public class Customer{

    private List<Book> myBookList = new ArrayList<Book>();

    public List<Movie> getMyMovieList() {
        return myMovieList;
    }

    private List<Movie> myMovieList = new ArrayList<Movie>();

    public List<Book> getMyBookList() {
        return myBookList;
    }

    public List<Book> borrowBook(Book borrowedBook) {
        myBookList.add(borrowedBook);
        return myBookList;
    }

    public void displayMyBookList() {
        if (myBookList.isEmpty()) {
            throw new InvalidBookException("Book List is Empty");
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
            throw new InvalidBookException("Customer doesn't have the book");
        }
        Book bookToBeReturned = isBookWithMe(bookId);
        if (bookToBeReturned != null) {
            myBookList.remove(bookToBeReturned);

        }
        return bookToBeReturned;
    }

    public List<Movie> borrowMovie(Movie movie) {
        myMovieList.add(movie);
        return myMovieList;
    }
}
