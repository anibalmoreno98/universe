package com.universe.cosmos_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.universe.cosmos_management.model.Galaxia;

/**
 * Repositorio JPA para la entidad {@link Galaxia}.
 *
 * <p>Proporciona operaciones CRUD y consultas básicas sobre la tabla de galaxias,
 * aprovechando la funcionalidad proporcionada por {@link JpaRepository}.</p>
 *
 * <p>Al extender JpaRepository, este repositorio hereda métodos como:
 * <ul>
 *   <li>findAll()</li>
 *   <li>findById(Integer id)</li>
 *   <li>save(Galaxia galaxia)</li>
 *   <li>deleteById(Integer id)</li>
 *   <li>existsById(Integer id)</li>
 * </ul>
 * sin necesidad de implementarlos manualmente.</p>
 */
public interface GalaxiaRepository extends JpaRepository<Galaxia, Integer> {
}
