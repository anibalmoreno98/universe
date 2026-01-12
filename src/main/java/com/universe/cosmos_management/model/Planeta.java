package com.universe.cosmos_management.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entidad que representa un planeta dentro del sistema.
 *
 * <p>Un planeta contiene información como su nombre, tamaño y si es gaseoso.
 * Además, mantiene relaciones con galaxias, lunas y minerales.</p>
 */
@Entity
@Table(name = "planeta_anibal")
public class Planeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "es_gaseoso", nullable = false)
    private boolean es_gaseoso;

    @Column(name = "tamanho", nullable = false)
    private int tamanho;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "galaxia_id", nullable = false)
    private Galaxia galaxia;

    @OneToMany(mappedBy = "planeta")
    private List<Luna> lunas;

    @ManyToMany
    @JoinTable(
        name = "planeta_mineral_anibal",
        joinColumns = @JoinColumn(name = "planeta_id"),
        inverseJoinColumns = @JoinColumn(name = "mineral_id")
    )
    private List<Mineral> minerales;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Planeta() {
    }

    /**
     * Constructor que permite inicializar un planeta con valores específicos.
     *
     * @param id identificador único del planeta
     * @param nombre nombre del planeta
     * @param tamanho tamaño del planeta
     * @param es_gaseoso indica si el planeta es gaseoso
     */
    public Planeta(int id, String nombre, int tamanho, boolean es_gaseoso) {
        this.id = id;
        this.nombre = nombre;
        this.tamanho = tamanho;
        this.es_gaseoso = es_gaseoso;
    }

    /**
     * Obtiene el identificador único del planeta.
     *
     * @return id del planeta
     */
    public int getId() {
        return id;
    }

    /**
     * Indica si el planeta es gaseoso.
     *
     * @return true si es gaseoso, false en caso contrario
     */
    public boolean isEs_gaseoso() {
        return es_gaseoso;
    }

    /**
     * Establece si el planeta es gaseoso.
     *
     * @param es_gaseoso nuevo valor del atributo
     */
    public void setEs_gaseoso(boolean es_gaseoso) {
        this.es_gaseoso = es_gaseoso;
    }

    /**
     * Obtiene el tamaño del planeta.
     *
     * @return tamaño del planeta
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Establece el tamaño del planeta.
     *
     * @param tamanho nuevo tamaño
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Obtiene el nombre del planeta.
     *
     * @return nombre del planeta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del planeta.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la galaxia a la que pertenece el planeta.
     *
     * @return galaxia asociada
     */
    public Galaxia getGalaxia() {
        return galaxia;
    }

    /**
     * Establece la galaxia a la que pertenece el planeta.
     *
     * @param galaxia nueva galaxia asociada
     */
    public void setGalaxia(Galaxia galaxia) {
        this.galaxia = galaxia;
    }

    /**
     * Obtiene la lista de lunas asociadas al planeta.
     *
     * @return lista de lunas
     */
    public List<Luna> getLunas() {
        return lunas;
    }

    /**
     * Establece la lista de lunas del planeta.
     *
     * @param lunas lista de lunas
     */
    public void setLunas(List<Luna> lunas) {
        this.lunas = lunas;
    }

    /**
     * Obtiene la lista de minerales presentes en el planeta.
     *
     * @return lista de minerales
     */
    public List<Mineral> getMinerales() {
        return minerales;
    }

    /**
     * Establece la lista de minerales del planeta.
     *
     * @param minerales lista de minerales
     */
    public void setMinerales(List<Mineral> minerales) {
        this.minerales = minerales;
    }
}

