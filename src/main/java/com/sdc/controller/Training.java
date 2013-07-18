package com.sdc.controller;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONObject;
import java.text.ParseException;



@Controller
@RequestMapping("/hi")
public class Training {
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody App getMethod() {

        App app = new App();
        app.setMethod("Metodo Usado: GET");

        return app;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postMethod(@RequestBody App json, ModelMap model) {

        model.addAttribute("message", "method:" + json.getMethod());
        return "hello";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody App putMethod() {

        App app = new App();
        app.setMethod("Metodo Usado: PUT");

        return app;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody App deleteMethod() {

        App app = new App();
        app.setMethod("Metodo Usado: DELETE");

        return app;
    }

    @RequestMapping(method = RequestMethod.HEAD)
    public @ResponseBody App headMethod() {

        App app = new App();
        app.setMethod("Metodo Usado: HEAD");

        return app;
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public @ResponseBody App optionsMethod() {

        App app = new App();
        app.setMethod("Metodo Usado: OPTIONS");

        return app;
    }
}