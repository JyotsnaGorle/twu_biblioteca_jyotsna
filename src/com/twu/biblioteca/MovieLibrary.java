package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jyotsna on 02/03/15.
 */
public class MovieLibrary implements ILibrary {

    List<Movie> listOfMovies = new ArrayList<Movie>();

    HashMap<String,Movie> borrowedMovies = new HashMap<String, Movie>();

    public MovieLibrary() {
        MovieList movieList = new MovieList();
        this.listOfMovies = movieList.movies;
    }

    public List<Movie> getListOfMovies() {
        return listOfMovies;
    }



    @Override
    public Movie find(String movieId) {
        for(Movie each:listOfMovies){
            if(each.getMovieId().equals(movieId))
                return each;
        }
        return null;
    }

    @Override
    public void display() {
        for(Movie each:listOfMovies){
            System.out.println(each.getMovieId()+" "+each.getTitle()+" "+each.getDirector()+" "+each.getYear()+" "+each.getRating());
        }

        }

    @Override
    public Movie checkout(LibraryMember libraryMember,String movieId) {
        Movie movie = find(movieId);
        if(movie !=null){
            listOfMovies.remove(movie);
            libraryMember.borrowMovie(movie);
            borrowedMovies.put(libraryMember.getId(),movie);
            return movie;
        }
        return null;
    }

    @Override
    public Movie returnItem(LibraryMember libraryMember, String bookId) {
        return null;
    }

}
