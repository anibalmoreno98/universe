package com.universe.cosmos_management.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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


    public Galaxia() {
    }

    public Galaxia(int codigo, int edad, String nombre) {
        this.codigo = codigo;
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }

    
}
