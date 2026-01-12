package com.universe.cosmos_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.universe.cosmos_management.service.PlanetaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador REST encargado de gestionar las operaciones relacionadas
 * con los planetas dentro del sistema. Proporciona endpoints para crear,
 * obtener, actualizar, eliminar y listar planetas, así como para consultar
 * los minerales asociados.
 */
@Controller
@RequestMapping("/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaService ps;

    /**
     * Constructor del controlador.
     *
     * @param ps servicio de gestión de planetas
     */
    public PlanetaController(PlanetaService ps) {
        this.ps = ps;
    }
    
    /**
     * Crea un nuevo planeta con los datos proporcionados.
     *
     * @param model modelo para pasar datos a la vista
     * @param nombre nombre del planeta
     * @param tamanho tamaño del planeta
     * @param es_gaseoso indica si el planeta es gaseoso
     * @param galaxiaId identificador de la galaxia a la que pertenece
     * @return nombre de la vista Thymeleaf que muestra el resultado
     */
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

    /**
     * Obtiene un planeta por su identificador.
     *
     * @param id identificador del planeta
     * @param model modelo para pasar datos a la vista
     * @return nombre de la vista que muestra el planeta encontrado
     */
    @GetMapping("/get/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("planeta", ps.getPlanetaById(id));
        return "planetaGet";
    }

    /**
     * Actualiza un planeta existente con los datos proporcionados.
     *
     * @param model modelo para pasar datos a la vista
     * @param id identificador del planeta
     * @param nombre nuevo nombre del planeta
     * @param tamanho nuevo tamaño del planeta
     * @param es_gaseoso nuevo estado gaseoso
     * @param galaxiaId nuevo identificador de la galaxia
     * @return nombre de la vista que muestra el resultado de la actualización
     */
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

    /**
     * Elimina un planeta por su identificador.
     *
     * @param model modelo para pasar datos a la vista
     * @param id identificador del planeta a eliminar
     * @return nombre de la vista que muestra el resultado de la eliminación
     */
    @GetMapping("/delete/{id}")
    public String delete(
        Model model,
        @PathVariable("id") int id
    ) {
        boolean deleted = ps.deletePlaneta(id);
        model.addAttribute("deleted", deleted);
        return "planetaDelete";
    }

    /**
     * Lista los planetas pertenecientes a una galaxia, ordenados de forma descendente.
     *
     * @param codigo identificador de la galaxia
     * @param model modelo para pasar datos a la vista
     * @return nombre de la vista que muestra la lista de planetas
     */
    @GetMapping("/galaxia/{codigo}/ordenados")
    public String getPlanetasOrdenados(@PathVariable int codigo, Model model) {
        model.addAttribute("planetas", ps.getPlanetasByGalaxiaOrdenados(codigo));
        return "listarPlanetas";
    }

    /**
     * Lista los minerales asociados a un planeta.
     *
     * @param id identificador del planeta
     * @param model modelo para pasar datos a la vista
     * @return nombre de la vista que muestra los minerales del planeta
     */
    @GetMapping("/{id}/minerales")
    public String getMinerales(@PathVariable int id, Model model) {
        model.addAttribute("minerales", ps.getMineralesDePlaneta(id));
        return "listarMinerales";
    }

}
