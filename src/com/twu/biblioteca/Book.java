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


    Book(String title, String author, String publishedYear){
        this.title=title;
        this.author =author;
        this.yearOfPublishing =publishedYear;
    }
    public static Book createBook(String title1, String author1, String publishedYear) {
        return new Book(title1,author1,publishedYear);
    }
}
