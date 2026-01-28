package com.universe.cosmos_management.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.universe.cosmos_management.repository.MoviesRepository;

@Service
public class MoviesService {

    private MoviesRepository moviesRepository;

    public MoviesService (MoviesRepository movieRepository) {
        this.moviesRepository = movieRepository;
    }

    public String insertarPelicula (String titulo, int duracion) {
        return this.moviesRepository.insertar(titulo, duracion);
    }

    public List<Document> readMovie(String title) {
        return this.moviesRepository.leer(title);
    }

    public boolean deleteMovie (String title) {
        return this.moviesRepository.borrar(title);
    }

    public boolean addLanguage (String title, String language) {
        return this.moviesRepository.addLanguage(title, language);
    }

    public boolean addProducer(String title, String productor) {
        return this.moviesRepository.addProducer(title, productor);
    }

    public boolean anhadirSponsor(String title, ArrayList<String> sponsor) {
        return this.moviesRepository.anhadirSponsor(title, null);
    }

    public boolean addDocument (String title, Document documento) {
        return this.moviesRepository.addDocument(title, documento);
    }

    public boolean eliminarPropiedad (String title, String propiedad) {
        return this.moviesRepository.eliminarPropiedad(title, propiedad);
    }

    public boolean eliminarValorArray (String title, String propiedadArray, String valor) {
        return this.moviesRepository.eliminarValorArray(title, propiedadArray, valor);
    }
}
