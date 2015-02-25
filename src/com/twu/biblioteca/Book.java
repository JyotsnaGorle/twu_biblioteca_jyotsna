package com.twu.biblioteca;

/**
 * Created by jyotsna on 25/02/15.
 */
public class Book {
    String title;
    String author;
    String yearOfPublishing;

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public String getYearOfPublishing() {
        return yearOfPublishing;
    }


    Book(String t, String a, String p){
        this.title=t;
        this.author =a;
        this.yearOfPublishing =p;
    }
    public static Book createBook(String t, String a, String p) {
        return new Book(t,a,p);
    }
}
