package com.sdc.controller;

import com.sdc.controller.BackEntities.Movie;
import com.sdc.controller.FrontEntities.ActorF;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class Training {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value="/movie/{movieId}", method = RequestMethod.GET)
    public @ResponseBody Movie getMethod(@PathVariable Long movieId) {

        return movieService.getMovie(movieId);
    }

    @RequestMapping(value="/actor", method = RequestMethod.POST)
    public String postMethod(@RequestBody ActorF json, ModelMap model) {

        String response = movieService.addActor(json);

        model.addAttribute("message", response);
        return "response";
    }









    /*
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    Movie putMethod() {

        Movie movie = new Movie();
        movie.setName("Sherlock Holmes");

        return movie;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody
    Movie deleteMethod() {

        Movie movie = new Movie();
        movie.setName("Sherlock Holmes");

        return movie;
    }

    @RequestMapping(method = RequestMethod.HEAD)
    public @ResponseBody
    Movie headMethod() {

        Movie movie = new Movie();
        movie.setName("Sherlock Holmes");

        return movie;
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public @ResponseBody
    Movie optionsMethod() {

        Movie movie = new Movie();
        movie.setName("Sherlock Holmes");

        return movie;
    } */
}