package com.sdc.controller;

import com.sdc.controller.BackEntities.Movie;
import com.sdc.controller.FrontEntities.ActorF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@SessionAttributes("var")
public class Training {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value="/movie", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("form", "command", new Movie());
    }

    @RequestMapping(value="/m", method = RequestMethod.POST)
            public String createMovie(ModelMap model, @ModelAttribute("Training") Movie movie, BindingResult result) {
                System.out.print(movie.toString());
                int r = movieService.addMovie(movie);

                if (r == 1){
                    model.addAttribute("message", movie);
                    return "movie";
        }
        else {
            model.addAttribute("message", "Se ha producido un error al insertar la pelicula.");
            return "response";
        }

    }

    @RequestMapping(value="/movie", method = RequestMethod.POST)
       public @ResponseBody Movie createMovieII(@RequestBody Movie json) {

        movieService.addMovie(json);
        return json;
    }

    @RequestMapping(value="/movie/{movieId}", method = RequestMethod.GET)
    public String getMovieByID(@PathVariable Long movieId, ModelMap model,
                               HttpServletResponse response) {

        model.addAttribute("message", movieService.getMovie(movieId));

        return "movie";
    }

    @RequestMapping(value="/actor", method = RequestMethod.POST)
    public String addActor(@RequestBody ActorF json, ModelMap model) {

        String response = movieService.addActor(json);

        model.addAttribute("message", response);
        return "response";
    }

    @RequestMapping(value="/getCookie", method = RequestMethod.GET)
    public String getCookie(ModelMap model, @CookieValue("cookiejava") String cookie){
        model.addAttribute("message", cookie);

        return "response";
    }

    @RequestMapping(value="/createCookie", method = RequestMethod.GET)
    public String createCookie(ModelMap model,HttpServletResponse response){
        Cookie c = new Cookie("cookiejava", "Cookie: "+Math.random());
        c.setMaxAge(60 * 60 * 24);
        response.addCookie(c);

        model.addAttribute("message", "Cookie creada...");

        return "response";
    }

    @RequestMapping(value="/session", method = RequestMethod.GET)
    public ModelAndView getSessionVar(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("var", "Variable: " + Math.random());
        modelAndView.setViewName("response");
        return modelAndView;
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