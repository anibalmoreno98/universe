package com.universe.cosmos_management.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Entidad que representa un mineral dentro del sistema.
 *
 * <p>Un mineral contiene información como su densidad y si es sólido,
 * además de su relación con los planetas en los que está presente.
 * La relación es muchos-a-muchos.</p>
 */
@Entity
@Table(name = "mineral_anibal")
public class Mineral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "densidad", nullable = false)
    private double densidad;

    @Column(name = "es_solido", nullable = false)
    private boolean es_solido;

    @ManyToMany(mappedBy = "minerales")
    private List<Planeta> planetas;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Mineral() {
    }

    /**
     * Constructor que permite inicializar un mineral con valores específicos.
     *
     * @param id identificador único del mineral
     * @param densidad densidad del mineral
     * @param es_solido indica si el mineral es sólido
     */
    public Mineral(int id, double densidad, boolean es_solido) {
        this.id = id;
        this.densidad = densidad;
        this.es_solido = es_solido;
    }

    /**
     * Obtiene el identificador único del mineral.
     *
     * @return id del mineral
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la densidad del mineral.
     *
     * @return densidad del mineral
     */
    public double getDensidad() {
        return densidad;
    }

    /**
     * Establece la densidad del mineral.
     *
     * @param densidad nueva densidad
     */
    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }

    /**
     * Indica si el mineral es sólido.
     *
     * @return true si es sólido, false en caso contrario
     */
    public boolean isEs_solido() {
        return es_solido;
    }

    /**
     * Establece si el mineral es sólido.
     *
     * @param es_solido nuevo valor del atributo
     */
    public void setEs_solido(boolean es_solido) {
        this.es_solido = es_solido;
    }

    /**
     * Obtiene la lista de planetas en los que está presente este mineral.
     *
     * @return lista de planetas asociados
     */
    public List<Planeta> getPlanetas() {
        return planetas;
    }

    /**
     * Establece la lista de planetas asociados a este mineral.
     *
     * @param planetas lista de planetas
     */
    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }
}
