package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 02/03/15.
 */
public class MovieLibrary implements ILibrary {

    List<Movie> listOfMovies = new ArrayList<Movie>();


    public MovieLibrary() {
        MovieList movieList = new MovieList();
        this.listOfMovies = movieList.movies;
    }

    public List<Movie> getListOfMovies() {
        return listOfMovies;
    }



    @Override
    public Object find(String movieId) {
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
    public Object checkout(Customer customer,String movieId) {
        Movie movie = (Movie)find(movieId);
        if(movie !=null){
            listOfMovies.add(movie);
            customer.borrowMovie(movie);
            return movie;
        }
        return null;
    }

    @Override
    public Object returnItem(Customer customer, String bookId) {
        return null;
    }


}
