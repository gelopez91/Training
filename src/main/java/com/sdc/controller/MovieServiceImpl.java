package com.sdc.controller;

import com.sdc.controller.BackEntities.ActorB;
import com.sdc.controller.FrontEntities.ActorF;
import com.sdc.controller.BackEntities.Movie;
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
    public String addActor(ActorF actor){
        ActorB a = new ActorB();
        a.setFirstName(actor.getFirstName());
        a.setLastName(actor.getLastName());
        a.setMovie(movieDAO.getMovie(Long.parseLong(String.valueOf(actor.getMovie_id()))));
        return movieDAO.addActor(a);
    }
}