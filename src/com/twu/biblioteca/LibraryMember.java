package com.twu.biblioteca;

import com.twu.biblioteca.domainObjects.Book;
import com.twu.biblioteca.domainObjects.Movie;
import com.twu.biblioteca.domainObjects.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 25/02/15.
 */

public class LibraryMember  extends User {
    String uName;
    String emailId;
    String phoneNo;

    private List<Book> myBookList = new ArrayList<Book>();

    public LibraryMember(String custId, String password, String uName, String emailId, String phoneNo) {
        super(custId, password);
        this.uName = uName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }

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

    public void displayMyItemList(ILibrary iLibrary) {
        if(iLibrary instanceof BookLibrary)
        displayMyBookList();
        else
            displayMyMovieList();
    }

    private void displayMyBookList() {
        if (myBookList.isEmpty()) {
            throw new InvalidItemException("Book List is Empty");
        } else {
            for (Book eachBook : myBookList) {
                System.out.println(eachBook.getBookId() + " \t\t   " + eachBook.getTitle() + " \t\t    " + eachBook.getAuthor() + " \t \t   " + eachBook.getYearOfPublishing());
            }
        }
    }
    private void displayMyMovieList() {
        if (myMovieList.isEmpty()) {
            throw new InvalidItemException("Movie List is Empty");
        } else {
            for (Movie each : myMovieList) {
                System.out.println(each.getMovieId()+" "+each.getTitle()+" "+each.getDirector()+" "+each.getYear()+" "+each.getRating());
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
            throw new InvalidItemException("Customer doesn't have the book");
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
