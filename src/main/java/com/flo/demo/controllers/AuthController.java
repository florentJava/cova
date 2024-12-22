package com.flo.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flo.demo.model.LoginRequest;
import com.flo.demo.model.LoginResponse;
import com.flo.demo.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/auth/login")
    @Operation(
        summary = " Se Connecter avec son mail et mot de passe" ,
        description ="prends en entree l'email et le mot de passe et retourne un jwt-Token"
    )
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated  LoginRequest request){


        String token = "";

        try {
            return ResponseEntity.ok(authService.loginService(request.getEmail(), request.getPassword()));
        } catch (Exception e) {
            // Crée une ResponseEntity avec le statut HTTP 500 (Internal Server Error)
            return ResponseEntity.status(404).body(new LoginResponse("error"));        
        }
        

    }
    
}
