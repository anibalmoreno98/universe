package com.universe.cosmos_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.universe.cosmos_management.service.PlanetaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planeta")
public class PlanetaController {

    private PlanetaService ps;

    public PlanetaController(PlanetaService ps) {
        this.ps = ps;
    }
    
    @GetMapping("/create/{nombre}/{tamanho}/{es_gaseoso}")
    public String create(
        Model model,
        @PathVariable("nombre") String nombre,
        @PathVariable("tamanho") int tamanho,
        @PathVariable("es_gaseoso") boolean es_gaseoso
    ) {
        
        boolean created = ps.createPlaneta(nombre, tamanho, es_gaseoso);

        model.addAttribute("created", created);

        return "createPlanet";
    }
    
}
