package com.universe.cosmos_management.controller;

import java.util.ArrayList;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.universe.cosmos_management.service.MoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping ("/movie")
public class MoviesController {

    private MoviesService moviesService;

    public MoviesController (MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/add/{title}/{duracion}")
    public String addMovie(@PathVariable String title, Model model, @PathVariable int duracion) {

        model.addAttribute("title", title);
        model.addAttribute("id", this.moviesService.insertarPelicula(title, duracion));

        return "movieView";
    }

    @GetMapping("/read/{title}")
    public String readMovie(@PathVariable String title, Model model) {
        model.addAttribute("peliculas", this.moviesService.readMovie(title));
        return "movieList";
    }

    @GetMapping("/delete/{title}")
    public String delete(@PathVariable String title, Model model) {
        model.addAttribute("borrada", this.moviesService.deleteMovie(title));
        model.addAttribute("titulo", title);
        return "movieErase";
    }
    
    @GetMapping("/addLanguage/{title}/{language}")
    public String addLanguage(@PathVariable String title,
                                @PathVariable String language,
                                Model model) {
        model.addAttribute("actualizado", this.moviesService.addLanguage(title, language));
        return "movieAddLanguage";
    }

    @GetMapping("/addProducer/{title}/{productor}")
    public String addProducer(@PathVariable String title,
                                @PathVariable String productor,
                                Model model) {
        model.addAttribute("actualizado", this.moviesService.addProducer(title, productor));
        return "movieAddProducer";
    }

    @GetMapping("/addSponsor/{title}/{sponsor}")
    public String anhadirSponsor(@PathVariable String title,
                                @PathVariable ArrayList<String> sponsor,
                                Model model) {
        model.addAttribute("actualizado", this.moviesService.anhadirSponsor(title, sponsor));
        return "movieAddSponsor";
    }
    
    @GetMapping("/addDocument/{title}/{key}/{value}")
    public String addDocument(@PathVariable String title,
                                @PathVariable String key,       // ejemplo: ayudantes
                                @PathVariable String value,     // ejemplo: alfonso
                                Model model) {

        Document documento = new Document(key, value);

        model.addAttribute("actualizado", moviesService.addDocument(title, documento));
        model.addAttribute("documento", documento);

        return "moviesAddDocument";
    }
    
    @GetMapping("/eliminarPropiedad/{title}/{propiedad}")
    public String eliminarPropiedad(@PathVariable String title,
                                    @PathVariable String propiedad,
                                    Model model) {
        model.addAttribute("borrada", this.moviesService.eliminarPropiedad(title, propiedad));
        return "moviesEliminarPropiedad";
    }
    
    @GetMapping("/eliminarValorArray/{title}/{propiedadArray}/{valor}")
    public String eliminarValorArray(@PathVariable String title,
                                    @PathVariable String propiedadArray,        // ejemplo: languages
                                    @PathVariable String valor,                 // ejemplo: English
                                    Model model) {

        boolean borrada = this.moviesService.eliminarValorArray(title, propiedadArray, valor);

        model.addAttribute("borrada",borrada);
        model.addAttribute("propiedadArray", propiedadArray);
        model.addAttribute("valor", valor);

        return "moviesEliminarPropiedadArray";
    }
    
}