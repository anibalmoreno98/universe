package com.universe.cosmos_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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


    public Luna() {
    }

    public Luna(int id, String nombre, double diametro, boolean tiene_crateres) {
        this.id = id;
        this.nombre = nombre;
        this.diametro = diametro;
        this.tiene_crateres = tiene_crateres;
    }

    
}
