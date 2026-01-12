package com.universe.cosmos_management.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entidad que representa una galaxia dentro del sistema.
 *
 * <p>Una galaxia contiene información básica como su nombre y edad,
 * además de una lista de planetas asociados mediante una relación
 * uno-a-muchos.</p>
 */
@Entity
@Table(name = "galaxia_anibal")
public class Galaxia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "edad")
    private int edad;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "galaxia")
    private List<Planeta> planetas;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Galaxia() {
    }

    /**
     * Constructor que permite inicializar una galaxia con valores específicos.
     *
     * @param codigo identificador único de la galaxia
     * @param edad edad aproximada de la galaxia
     * @param nombre nombre asignado a la galaxia
     */
    public Galaxia(int codigo, int edad, String nombre) {
        this.codigo = codigo;
        this.edad = edad;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único de la galaxia.
     *
     * @return código de la galaxia
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Obtiene la edad de la galaxia.
     *
     * @return edad de la galaxia
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la galaxia.
     *
     * @param edad nueva edad de la galaxia
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el nombre de la galaxia.
     *
     * @return nombre de la galaxia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la galaxia.
     *
     * @param nombre nuevo nombre de la galaxia
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de planetas asociados a esta galaxia.
     *
     * @return lista de planetas
     */
    public List<Planeta> getPlanetas() {
        return planetas;
    }

    /**
     * Establece la lista de planetas pertenecientes a esta galaxia.
     *
     * @param planetas lista de planetas
     */
    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }
}
