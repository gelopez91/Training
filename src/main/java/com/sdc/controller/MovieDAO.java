package com.sdc.controller;

import com.sdc.controller.BackEntities.ActorB;
import com.sdc.controller.BackEntities.Movie;
import org.springframework.dao.DataAccessException;

public interface MovieDAO {
    public Movie getMovie(int movieId) throws DataAccessException;
    public int addMovie(Movie movie);
    public String addActor(ActorB actor);
}