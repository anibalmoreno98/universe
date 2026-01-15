package com.universe.cosmos_management.repository;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import static com.mongodb.client.model.Filters.*;

@Repository
public class MoviesRepository {

    MongoClient cliente = null;

    private void crearCliente() {
        this.cliente = MongoClients.create(
            MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString
                    ("mongodb+srv://anibalmoreno1998_db_user:1234@database.b5fj9xe.mongodb.net/?appName=database"))
                .build());
    }

    private void desconectar() {
        if (this.cliente!=null) {
            this.cliente.close();
        }
    }

    public String insertar (String titulo, int duracion) {

        crearCliente();

        Document pelicula = new Document("titulo", titulo)
            .append("duracion", 120);

        MongoDatabase baseDeDatos = this.cliente.getDatabase("sample_mflix");
        MongoCollection peliculas = baseDeDatos.getCollection("movies");

        InsertOneResult result = peliculas.insertOne(pelicula);

        desconectar();

        if (result.wasAcknowledged()){
            return result.getInsertedId().asObjectId().getValue().toString();
        } else {
            return "Indefinido";
        }
    }

    public Object leer(String title) {
        crearCliente();

        MongoDatabase baseDeDatos = this.cliente.getDatabase("sample_mflix");
        MongoCollection peliculas = baseDeDatos.getCollection("movies");

        Bson equalComparison = eq("titulo", title);


        peliculas.find(equalComparison);

        desconectar();

        return "";
    }

    
}
