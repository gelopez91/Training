package com.sdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@RequestMapping("/movie")
public class Training {
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Movie getMethod() {

        Movie movie = new Movie();
        movie.setName("Sherlock Holmes");

        return movie;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postMethod(@RequestBody Movie json, ModelMap model) {

        model.addAttribute("message", "name:" + json.getName());
        return "hello";
    }

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
    }
}