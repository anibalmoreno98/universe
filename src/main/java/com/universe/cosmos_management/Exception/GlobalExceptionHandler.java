package com.universe.cosmos_management.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;

/**
 * Manejador global de excepciones para la aplicación.
 *
 * <p>Esta clase captura y gestiona excepciones lanzadas por los controladores,
 * permitiendo centralizar el tratamiento de errores y mostrar una vista
 * unificada de error al usuario.</p>
 *
 * <p>Gracias a {@link ControllerAdvice}, Spring intercepta automáticamente
 * las excepciones y redirige a los métodos correspondientes según su tipo.</p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones del tipo {@link EntityNotFoundException},
     * típicamente lanzadas cuando una entidad no existe en la base de datos.
     *
     * @param ex excepción capturada
     * @param model modelo para pasar información a la vista
     * @return nombre de la vista de error
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNotFound(EntityNotFoundException ex, Model model) {
        model.addAttribute("error", "No se encontró la entidad solicitada");
        return "error";
    }

    /**
     * Maneja excepciones relacionadas con el acceso a la base de datos,
     * como errores de conexión o violaciones de integridad.
     *
     * @param ex excepción capturada
     * @param model modelo para pasar información a la vista
     * @return nombre de la vista de error
     */
    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseError(DataAccessException ex, Model model) {
        model.addAttribute("error", "Error de acceso a la base de datos");
        return "error";
    }

    /**
     * Maneja cualquier otra excepción no contemplada por métodos específicos.
     *
     * @param ex excepción capturada
     * @param model modelo para pasar información a la vista
     * @return nombre de la vista de error genérico
     */
    @ExceptionHandler(Exception.class)
    public String handleGeneralError(Exception ex, Model model) {
        model.addAttribute("error", "Ha ocurrido un error inesperado");
        return "error";
    }
}
