package com.universe.cosmos_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.universe.cosmos_management.model.Luna;

/**
 * Repositorio JPA para la entidad {@link Luna}.
 *
 * <p>Proporciona operaciones CRUD y consultas básicas sobre la tabla de lunas,
 * aprovechando la funcionalidad proporcionada por {@link JpaRepository}.</p>
 *
 * <p>Al extender JpaRepository, este repositorio hereda métodos como:
 * <ul>
 *   <li>findAll()</li>
 *   <li>findById(Integer id)</li>
 *   <li>save(Luna luna)</li>
 *   <li>deleteById(Integer id)</li>
 *   <li>existsById(Integer id)</li>
 * </ul>
 * sin necesidad de implementarlos manualmente.</p>
 */
public interface LunaRepository extends JpaRepository<Luna, Integer> {
}
