package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 02/03/15.
 */
public class MovieList {
    List<Movie> movies = new ArrayList<Movie>();

    MovieList(){
        this.movies = moviesList;
    }
    List<Movie> moviesList = new ArrayList<Movie>(){
        {
            add(new Movie("1","movie1","director1","4/5"));
            add(new Movie("2","movie2","director2","2/5"));
            add(new Movie("3","movie3","director3","3/5"));
            add(new Movie("4","movie4","director4","1/5"));
        }
    };
}
