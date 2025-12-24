package com.universe.cosmos_management.controller;

import org.springframework.stereotype.Controller;

import com.universe.cosmos_management.service.PlanetaService;

@Controller
public class PlanetaController {

    private PlanetaService ps;

    public PlanetaController(PlanetaService ps) {
        this.ps = ps;
    }
    
}
