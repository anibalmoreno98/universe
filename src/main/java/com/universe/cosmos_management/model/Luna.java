package com.universe.cosmos_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad que representa una luna dentro del sistema.
 *
 * <p>Una luna contiene información como su nombre, diámetro y si posee cráteres.
 * Además, está asociada a un planeta mediante una relación muchos-a-uno.</p>
 */
@Entity
@Table(name = "luna_anibal")
public class Luna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "diametro", nullable = false)
    private double diametro;

    @Column(name = "tiene_crateres", nullable = false)
    private boolean tiene_crateres;

    @ManyToOne
    @JoinColumn(name = "planeta_id", nullable = false)
    private Planeta planeta;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Luna() {
    }

    /**
     * Constructor que permite inicializar una luna con valores específicos.
     *
     * @param id identificador único de la luna
     * @param nombre nombre de la luna
     * @param diametro diámetro de la luna
     * @param tiene_crateres indica si la luna posee cráteres
     */
    public Luna(int id, String nombre, double diametro, boolean tiene_crateres) {
        this.id = id;
        this.nombre = nombre;
        this.diametro = diametro;
        this.tiene_crateres = tiene_crateres;
    }

    /**
     * Obtiene el identificador único de la luna.
     *
     * @return id de la luna
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre de la luna.
     *
     * @return nombre de la luna
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la luna.
     *
     * @param nombre nuevo nombre de la luna
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el diámetro de la luna.
     *
     * @return diámetro de la luna
     */
    public double getDiametro() {
        return diametro;
    }

    /**
     * Establece el diámetro de la luna.
     *
     * @param diametro nuevo diámetro
     */
    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    /**
     * Indica si la luna posee cráteres.
     *
     * @return true si tiene cráteres, false en caso contrario
     */
    public boolean isTiene_crateres() {
        return tiene_crateres;
    }

    /**
     * Establece si la luna posee cráteres.
     *
     * @param tiene_crateres nuevo valor del atributo
     */
    public void setTiene_crateres(boolean tiene_crateres) {
        this.tiene_crateres = tiene_crateres;
    }

    /**
     * Obtiene el planeta al que pertenece la luna.
     *
     * @return planeta asociado
     */
    public Planeta getPlaneta() {
        return planeta;
    }

    /**
     * Establece el planeta al que pertenece la luna.
     *
     * @param planeta nuevo planeta asociado
     */
    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }
}

