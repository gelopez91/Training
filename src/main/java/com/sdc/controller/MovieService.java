package com.sdc.controller;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    public Movie getMovie(Long id);
    public String addMovie(Movie movie);
}
