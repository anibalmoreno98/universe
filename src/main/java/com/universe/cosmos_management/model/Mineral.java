package com.universe.cosmos_management.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

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


    public Mineral() {
    }

    public Mineral(int id, double densidad, boolean es_solido) {
        this.id = id;
        this.densidad = densidad;
        this.es_solido = es_solido;
    }

    public int getId() {
        return id;
    }

    public double getDensidad() {
        return densidad;
    }

    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }

    public boolean isEs_solido() {
        return es_solido;
    }

    public void setEs_solido(boolean es_solido) {
        this.es_solido = es_solido;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }

    
    
}
