package com.sdc.controller;

import org.springframework.dao.DataAccessException;

public interface MovieDAO {
    public Movie getMovie(Long movieId) throws DataAccessException;
    public String addMovie(Movie movie);
}