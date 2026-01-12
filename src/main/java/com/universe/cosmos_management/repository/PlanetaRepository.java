package com.universe.cosmos_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universe.cosmos_management.model.Planeta;

/**
 * Repositorio JPA para la entidad {@link Planeta}.
 *
 * <p>Proporciona operaciones CRUD y consultas básicas sobre la tabla de planetas,
 * aprovechando la funcionalidad de {@link JpaRepository}.</p>
 *
 * <p>Incluye además un método personalizado para obtener los planetas de una galaxia
 * ordenados por tamaño en orden descendente.</p>
 */
public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {

    /**
     * Obtiene los planetas pertenecientes a una galaxia específica,
     * ordenados por tamaño de mayor a menor.
     *
     * @param codigoGalaxia identificador de la galaxia
     * @return lista de planetas ordenados por tamaño descendente
     */
    List<Planeta> findByGalaxiaCodigoOrderByTamanhoDesc(int codigoGalaxia);
    
}
