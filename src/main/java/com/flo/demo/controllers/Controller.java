package com.flo.demo.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flo.demo.security.UserPrincipal;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class Controller {

    @GetMapping("/")
    @Operation(
        summary = "Permet de testet l'API. " ,
        description ="Permet de tester l'API sans meme s'authentifier"
    )
    public String greeting() {
        return  "Hello World!";
    }

    @Operation(
        summary = "Verifie si un utilisateur est authentifier" ,
        description ="Verifie si le token d'un utilisateur est correct"
    )
    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal  UserPrincipal principal) {
        return  "if you see this, then  you log in  as  " +
                principal.getEmail() + " UserId  " + principal.getUserId() +" Role  " + principal.getAuthorities();
    }    
}
