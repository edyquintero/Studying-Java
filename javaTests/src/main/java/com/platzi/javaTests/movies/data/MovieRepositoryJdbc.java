package com.platzi.javaTests.movies.data;

import com.platzi.javaTests.movies.model.Genre;
import com.platzi.javaTests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepositoryJdbc implements MovieRepository {
    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name, minutes, genre) values (?, ?, ?)", movie.getName(), movie.getMinutes(), movie.getGenre().toString());

    }

    @Override
    public Collection<Movie> findByName(String movieName) {
        List<Movie> allMovies = jdbcTemplate.query("select * from movies", movieMapper);
        return allMovies.stream().filter(movie -> movie.getName().contains(movieName)).collect(Collectors.toList());
    }

    private static RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Movie(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("minutes"),
                        Genre.valueOf(resultSet.getString("genre")));
            }
        };
}
