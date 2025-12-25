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

    public Planeta(int id, boolean es_gaseoso, int tamanho, String nombre) {
        this.id = id;
        this.es_gaseoso = es_gaseoso;
        this.tamanho = tamanho;
        this.nombre = nombre;
    }

    
}
