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



    public Planeta() {
    }

    public Planeta(int id, String nombre, int tamanho, boolean es_gaseoso) {
        this.id = id;
        this.nombre = nombre;
        this.tamanho = tamanho;
        this.es_gaseoso = es_gaseoso;
        
    }

    public int getId() {
        return id;
    }

    public boolean isEs_gaseoso() {
        return es_gaseoso;
    }

    public void setEs_gaseoso(boolean es_gaseoso) {
        this.es_gaseoso = es_gaseoso;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Galaxia getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(Galaxia galaxia) {
        this.galaxia = galaxia;
    }

    public List<Luna> getLunas() {
        return lunas;
    }

    public void setLunas(List<Luna> lunas) {
        this.lunas = lunas;
    }

    public List<Mineral> getMinerales() {
        return minerales;
    }

    public void setMinerales(List<Mineral> minerales) {
        this.minerales = minerales;
    }

    
    
}
