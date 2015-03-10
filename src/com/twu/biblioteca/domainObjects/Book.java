package com.twu.biblioteca.domainObjects;

/**
 * @author jyotsna
 */
public class Book {

    private String bookId;
    private String title;
    private String author;
    private String yearOfPublishing;

    public String getBookId() {
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


    Book(String bookId,String title, String author, String publishedYear){
        this.bookId = bookId;
        this.title=title;
        this.author =author;
        this.yearOfPublishing =publishedYear;
    }
    public static Book createBook(String bookId,String title1, String author1, String publishedYear) {
        return new Book(bookId,title1,author1,publishedYear);
    }
}
