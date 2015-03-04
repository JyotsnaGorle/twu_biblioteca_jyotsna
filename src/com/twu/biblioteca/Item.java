package com.twu.biblioteca;

/**
 * Created by jyotsna on 03/03/15.
 */
public class Item {
    public Movie getBook() {
        return movie;
    }

    public Book getMovie() {
        return book;
    }

    public String getUserId() {
        return userId;
    }

    Book book;
Movie movie;
String userId;

    public Item(Book checkedItem, String userId) {
        this.book = checkedItem;
        this.userId = userId;
        this.movie=null;
    }

    public Item(Movie checkedItem, String userId) {
        this.movie=checkedItem;
        this.userId=userId;
        this.book=null;
    }


    public String getItemInfo() {
        String info="";
        if(movie==null){
            info +=book.getBookId()+"  "+book.getTitle()+"  "+book.getAuthor()+"  "+book.getYearOfPublishing()+"  "+userId;
        }
        else {
            info +=movie.getMovieId()+"  "+movie.getTitle()+"  "+movie.getDirector()+"  "+movie.getRating()+"  "+movie.getYear()+"  "+userId;
        }
        return info;
    }
}
