package com.universe.cosmos_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.universe.cosmos_management.model.Planeta;
import com.universe.cosmos_management.service.PlanetaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaService ps;

    public PlanetaController(PlanetaService ps) {
        this.ps = ps;
    }
    
    // create
    @GetMapping("/create/{nombre}/{tamanho}/{es_gaseoso}/{galaxia_id}")
    public String create(
        Model model,
        @PathVariable("nombre") String nombre,
        @PathVariable("tamanho") int tamanho,
        @PathVariable("es_gaseoso") boolean es_gaseoso,
        @PathVariable("galaxia_id") int galaxiaId
    ) {
        
        boolean created = ps.createPlaneta(nombre, tamanho, es_gaseoso, galaxiaId);

        model.addAttribute("created", created);

        return "planetaCreate";
    }

    //getById
    @GetMapping("/get/{id}")
    public Planeta getById(@PathVariable("id") int id) {
        return ps.getPlanetaById(id);
    }

    // update
    @GetMapping("/update/{id}/{nombre}/{tamanho}/{es_gaseoso}/{galaxia_id}")
    public String update(
        Model model,
        @PathVariable("id") int id,
        @PathVariable("nombre") String nombre,
        @PathVariable("tamanho") int tamanho,
        @PathVariable("es_gaseoso") boolean es_gaseoso,
        @PathVariable("galaxia_id") int galaxiaId
    ) {
        boolean updated = ps.updatePlaneta(id, nombre, tamanho, es_gaseoso, galaxiaId);
        model.addAttribute("updated", updated);
        return "planetaUpdate";
    }

    // delete
    @GetMapping("/delete/{id}")
    public String delete(
        Model model,
        @PathVariable("id") int id
    ) {
        boolean deleted = ps.deletePlaneta(id);
        model.addAttribute("deleted", deleted);
        return "planetaDelete";
    }
}
