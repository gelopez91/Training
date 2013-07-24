package com.sdc.controller;

import com.sdc.controller.BackEntities.Movie;
import com.sdc.controller.FrontEntities.ActorF;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    public Movie getMovie(Long id);
    public String addActor(ActorF actor);
}
