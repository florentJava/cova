package com.flo.demo.service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jakarta.persistence.EntityNotFoundException;




@RestControllerAdvice
public class ExeceptionHandler {
    

     /*
     * Erreur lors de la recherche d'une entite dans la BD
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public Map<String, String> handleEntityNotFoundException(EntityNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Entity not found");
        errorResponse.put("message", ex.getMessage());
        return errorResponse;
    }

    
        @ExceptionHandler(AuthenticationException.class)
        public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex, WebRequest request) {
            return new ResponseEntity<>("Authentication failed: " + ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
            return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

     /*
     * Runtime Exception
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, String> handleEntityNotFoundException(RuntimeException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Runtime Exception");
        errorResponse.put("message", ex.getMessage());
        return errorResponse;
    }
}