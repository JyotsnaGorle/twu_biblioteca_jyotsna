package com.twu.biblioteca;

/**
 * Created by jyotsna on 25/02/15.
 */
public class Book {


    int bookId;
    String title;
    String author;
    String yearOfPublishing;

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public String getYearOfPublishing() {
        return yearOfPublishing;
    }


    Book(int bookId,String title, String author, String publishedYear){
        this.bookId = bookId;
        this.title=title;
        this.author =author;
        this.yearOfPublishing =publishedYear;
    }
    public static Book createBook(int bookId,String title1, String author1, String publishedYear) {
        return new Book(bookId,title1,author1,publishedYear);
    }
}
