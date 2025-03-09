package com.platzi.javaTests.movies.data;

import com.platzi.javaTests.movies.model.Genre;
import com.platzi.javaTests.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
    Collection<Movie> findByName(String movieName);
}
