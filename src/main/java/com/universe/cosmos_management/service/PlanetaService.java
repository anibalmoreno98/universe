package com.universe.cosmos_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.universe.cosmos_management.model.Galaxia;
import com.universe.cosmos_management.model.Mineral;
import com.universe.cosmos_management.model.Planeta;
import com.universe.cosmos_management.repository.GalaxiaRepository;
import com.universe.cosmos_management.repository.PlanetaRepository;

/**
 * Servicio encargado de gestionar las operaciones relacionadas con los planetas.
 * Proporciona métodos para crear, obtener, actualizar, eliminar y consultar
 * planetas, así como para acceder a sus minerales asociados.
 */
@Service
public class PlanetaService {

    private PlanetaRepository pr;
    private final GalaxiaRepository gr;

    /**
     * Constructor del servicio.
     *
     * @param pr repositorio de planetas
     * @param gr repositorio de galaxias
     */
    public PlanetaService(PlanetaRepository pr, GalaxiaRepository gr) {
        this.pr = pr;
        this.gr = gr;
    }

    /**
     * Crea un nuevo planeta asociado a una galaxia existente.
     *
     * @param nombre nombre del planeta
     * @param tamanho tamaño del planeta
     * @param es_gaseoso indica si el planeta es gaseoso
     * @param galaxiaId identificador de la galaxia a la que pertenece
     * @return true si el planeta se creó correctamente, false en caso contrario
     */
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

    /**
     * Obtiene un planeta por su identificador.
     *
     * @param id identificador del planeta
     * @return el planeta encontrado o null si no existe
     */
    public Planeta getPlanetaById(int id) {
        return pr.findById(id).orElse(null);
    }

    /**
     * Actualiza los datos de un planeta existente.
     *
     * @param id identificador del planeta
     * @param nombre nuevo nombre del planeta
     * @param tamanho nuevo tamaño del planeta
     * @param es_gaseoso nuevo estado gaseoso
     * @param galaxiaId identificador de la galaxia asociada
     * @return true si la actualización fue exitosa, false si el planeta o la galaxia no existen
     */
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

    /**
     * Elimina un planeta por su identificador.
     *
     * @param id identificador del planeta
     * @return true si el planeta fue eliminado, false si no existe o ocurre un error
     */
    public boolean deletePlaneta(int id) {
        try {
            if (!pr.existsById(id)) return false;
            pr.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Obtiene los planetas pertenecientes a una galaxia, ordenados por tamaño descendente.
     *
     * @param codigoGalaxia identificador de la galaxia
     * @return lista de planetas ordenados
     */
    public List<Planeta> getPlanetasByGalaxiaOrdenados(int codigoGalaxia) {
        return pr.findByGalaxiaCodigoOrderByTamanhoDesc(codigoGalaxia);
    }

    /**
     * Obtiene la lista de minerales asociados a un planeta.
     *
     * @param planetaId identificador del planeta
     * @return lista de minerales o null si el planeta no existe
     */
    public List<Mineral> getMineralesDePlaneta(int planetaId) {
        Planeta p = pr.findById(planetaId).orElse(null);
        if (p == null) return null;
        return p.getMinerales();
    }

}
