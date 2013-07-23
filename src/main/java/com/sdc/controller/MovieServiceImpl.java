package com.sdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDAO;

    @Transactional
    public Movie getMovie(Long id) {
        return movieDAO.getMovie(id);
    }

    @Transactional (propagation = Propagation.REQUIRED)
    public String addMovie(Movie movie){
        return movieDAO.addMovie(movie);
    }
}