package com.universe.cosmos_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universe.cosmos_management.model.Planeta;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer>{

    List<Planeta> findByGalaxiaCodigoOrderByTamanhoDesc(int codigoGalaxia);
    
}
