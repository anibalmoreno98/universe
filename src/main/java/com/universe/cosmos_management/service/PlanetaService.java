package com.universe.cosmos_management.service;

import org.springframework.stereotype.Service;

import com.universe.cosmos_management.model.Planeta;
import com.universe.cosmos_management.repository.PlanetaRepository;

@Service
public class PlanetaService {

    private PlanetaRepository pr;

    public PlanetaService(PlanetaRepository pr) {
        this.pr = pr;
    }

    public boolean createPlaneta(String nombre, int tamanho, boolean es_gaseoso) {
        try {
            Planeta p = new Planeta();
            p.setNombre(nombre);
            p.setTamanho(tamanho);
            p.setEs_gaseoso(es_gaseoso);

            pr.save(p);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
}
