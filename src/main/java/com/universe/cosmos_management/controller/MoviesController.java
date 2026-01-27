package com.universe.cosmos_management.controller;

import java.util.ArrayList;

import org.bson.Document;
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
    public String getMethodName(@PathVariable String title, @PathVariable String language, Model model) {
        model.addAttribute("actualizado", this.moviesService.addLanguage(title, language));
        return "movieUpdated";
    }

    @GetMapping("/modifyAndAddProducer/{title}/{productor}")
    public String modifyAndAddProducer(@PathVariable String title, @PathVariable String productor, Model model) {
        model.addAttribute("actualizado", this.moviesService.modificarPeliculaYAnhadirProductor(title, productor));
        return "modifyAndAddProducer";
    }

    @GetMapping("/addSponsor/{title}/{sponsor}")
    public String anhadirSponsor(@PathVariable String title, ArrayList<String> sponsor, Model model) {
        model.addAttribute("actualizado", this.moviesService.anhadirSponsor(title, sponsor));
        return "movieAddSponsor";
    }
    
    @GetMapping("/movies/{title}/{documento}")
    public String anhadirDocumento(@PathVariable String title, Document documento, Model model) {
        model.addAttribute("actualizado", this.moviesService.anhadirDocumento(title, documento));
        return "moviesAddDocument";
    }
    
    @GetMapping("/movies/{title}/{propiedad}")
    public String eliminarPropiedad(@PathVariable String title, String propiedad, Model model) {
        model.addAttribute("borrada", this.moviesService.eliminarPropiedad(title, propiedad));
        return new String();
    }
    
    @GetMapping("/movies/{title}/{propiedadArray}/{valor}")
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