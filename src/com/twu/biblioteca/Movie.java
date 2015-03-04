package com.twu.biblioteca;

/**
 * Created by jyotsna on 02/03/15.
 */
public class Movie {

    private String movieId;
    private String title;
    private String year;
    private String director;
    private String rating;

    public Movie(String movieId, String title, String director, String rating,String year) {
        this.movieId=movieId;
        this.title=title;
        this.year=year;
        this.director=director;
        this.rating=rating;

    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }





}
