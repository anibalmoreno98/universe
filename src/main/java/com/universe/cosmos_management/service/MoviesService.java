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
        return this.moviesRepository.anhadirIdioma(title, language);
    }

    public boolean modificarPeliculaYAnhadirProductor(String title, String productor) {
        return this.moviesRepository.modificarPeliculaYAnhadirProductor(title, productor);
    }

    public boolean anhadirSponsor(String title, ArrayList<String> sponsor) {
        return this.moviesRepository.anhadirSponsor(title, null);
    }

    public boolean anhadirDocumento (String title, Document documento) {
        return this.moviesRepository.anhadirDocumento(title, documento);
    }
}
