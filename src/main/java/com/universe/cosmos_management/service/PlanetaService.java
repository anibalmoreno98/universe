package com.universe.cosmos_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.universe.cosmos_management.model.Galaxia;
import com.universe.cosmos_management.model.Mineral;
import com.universe.cosmos_management.model.Planeta;
import com.universe.cosmos_management.repository.GalaxiaRepository;
import com.universe.cosmos_management.repository.PlanetaRepository;

@Service
public class PlanetaService {

    private PlanetaRepository pr;
    private final GalaxiaRepository gr;

    public PlanetaService(PlanetaRepository pr, GalaxiaRepository gr) {
        this.pr = pr;
        this.gr = gr;
    }

    public boolean createPlaneta(String nombre, int tamanho, boolean es_gaseoso, int galaxiaId) {
        try {
            Galaxia g = gr.findById(galaxiaId).orElse(null);
            if (g == null) return false;

            Planeta p = new Planeta();
            p.setNombre(nombre);
            p.setTamanho(tamanho);
            p.setEs_gaseoso(es_gaseoso);
            p.setGalaxia(g);

            pr.save(p);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Planeta getPlanetaById(int id) {
    return pr.findById(id).orElse(null);
    }

    public boolean updatePlaneta(int id, String nombre, int tamanho, boolean es_gaseoso, int galaxiaId) {
        try {
            Planeta p = pr.findById(id).orElse(null);
            if (p == null) return false;

            Galaxia g = gr.findById(galaxiaId).orElse(null);
            if (g == null) return false;

            p.setNombre(nombre);
            p.setTamanho(tamanho);
            p.setEs_gaseoso(es_gaseoso);
            p.setGalaxia(g);

            pr.save(p);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean deletePlaneta(int id) {
        try {
            if (!pr.existsById(id)) return false;
            pr.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Planeta> getPlanetasByGalaxiaOrdenados(int codigoGalaxia) {
    return pr.findByGalaxiaCodigoOrderByTamanhoDesc(codigoGalaxia);
    }

    public List<Mineral> getMineralesDePlaneta(int planetaId) {
        Planeta p = pr.findById(planetaId).orElse(null);
        if (p == null) return null;
        return p.getMinerales();
    }


}
