package com.universe.cosmos_management.service;

import org.springframework.stereotype.Service;

import com.universe.cosmos_management.repository.PlanetaRepository;

@Service
public class PlanetaService {

    private PlanetaRepository pr;

    public PlanetaService(PlanetaRepository pr) {
        this.pr = pr;
    }
    
}
