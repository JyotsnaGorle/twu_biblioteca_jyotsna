package com.twu.biblioteca;

/**
 * Created by jyotsna on 25/02/15.
 */
public class Book {
    String title;
    String author;
    String year_of_publishing;

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public String getYear_of_publishing() {
        return year_of_publishing;
    }


    Book(String t, String a, String p){
        this.title=t;
        this.author =a;
        this.year_of_publishing=p;
    }
    public static Book createBook(String t, String a, String p) {
        return new Book(t,a,p);
    }
}
