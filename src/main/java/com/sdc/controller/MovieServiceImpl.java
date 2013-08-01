package com.sdc.controller;

import com.sdc.controller.BackEntities.ActorB;
import com.sdc.controller.BackEntities.Movie;
import com.sdc.controller.FrontEntities.ActorF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDAO;

    @Transactional
    public Movie getMovie(int id) {
        return movieDAO.getMovie(id);
    }

    @Transactional
    public int addMovie(Movie movie){
        return movieDAO.addMovie(movie);
    }

    @Transactional (propagation = Propagation.REQUIRED)
    public String addActor(ActorF actor){
        ActorB a = new ActorB();
        a.setFirstName(actor.getFirstName());
        a.setLastName(actor.getLastName());
        a.setMovie(movieDAO.getMovie(actor.getMovie_id()));
        return movieDAO.addActor(a);
    }

    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }
}