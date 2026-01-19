package com.universe.cosmos_management.service;

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

}
