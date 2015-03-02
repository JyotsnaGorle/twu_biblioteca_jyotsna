package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 02/03/15.
 */
public class MovieLibrary {

    List<Movie> listOfMovies = new ArrayList<Movie>();


    public MovieLibrary() {
        MovieList movieList = new MovieList();
        this.listOfMovies = movieList.movies;
    }

    public List<Movie> getListOfMovies() {
        return listOfMovies;
    }


    public Movie isMovieAvailable(String movieId) {
        for(Movie each:listOfMovies){
            if(each.getMovieId().equals(movieId))
                return each;
        }
        return null;
    }

    public Movie checkout(Customer customer, String movieId) {
        Movie movie = isMovieAvailable(movieId);
        if(movie !=null){
            listOfMovies.add(movie);
            customer.borrowMovie(movie);
            return movie;
        }
        return null;
    }
}
