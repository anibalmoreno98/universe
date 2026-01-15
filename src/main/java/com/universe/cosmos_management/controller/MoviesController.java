package com.universe.cosmos_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.universe.cosmos_management.service.MoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping ("/movie")
public class MoviesController {

    private MoviesService moviesService;

    public MoviesController (MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/add/{title}/{duracion}")
    public String addMovie(@PathVariable String title, Model model, int duracion) {

        model.addAttribute("title", title);
        model.addAttribute("id", this.moviesService.insertarPelicula(title, duracion));

        return "movieView";
    }

    @GetMapping("/read/{title}")
    public String readMovie(@PathVariable String title, Model model) {
        model.AddAttribute("pelicula", this.moviesService.readMovie(title));
        return "movieShow";
    }
    
    
    
}
