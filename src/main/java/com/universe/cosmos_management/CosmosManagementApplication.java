package com.universe.cosmos_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Cosmos Management.
 * 
 * <p>Esta clase actúa como punto de entrada del proyecto Spring Boot.
 * Al ejecutarse, inicializa el contexto de Spring, configura los
 * componentes necesarios y pone en marcha la aplicación.</p>
 */
@SpringBootApplication
public class CosmosManagementApplication {

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(CosmosManagementApplication.class, args);
    }

}
