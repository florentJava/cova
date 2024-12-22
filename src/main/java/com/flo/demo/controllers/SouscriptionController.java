package com.flo.demo.controllers;




import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flo.demo.dtos.SouscriptionDto;
import com.flo.demo.service.SouscripService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;







@RestController
@RequiredArgsConstructor
@RequestMapping("/souscription/")
public class SouscriptionController {

    private final SouscripService service;

    @GetMapping("{id}")
    @Operation(
        summary = "Recuperer une souscription par son id" ,
        description ="Recuperer une souscription par son id"
    )
    public SouscriptionDto getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("")
    @Operation(
        summary = "Liste de toutes les souscriptions" ,
        description ="Retourne la liste de toutes les souscriptions"
    )
    public List<SouscriptionDto> getAll() {
        return service.getAll();
    }


    @PostMapping("")
    @Operation(
        summary = "Ajouter une nouvelle souscription" ,
        description ="Ajoute une nouvelle souscription"
    )
    public SouscriptionDto create(@RequestBody SouscriptionDto sDto) {
        return service.create(sDto);
    }

    @PutMapping("{id}")
    @Operation(
        summary = "Modifier une souscription" ,
        description ="Modifie une souscription"
    )
    public boolean updateSouscription(@PathVariable String id, @RequestBody SouscriptionDto sDto) {        
        return service.update(sDto, id);
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Supprimer une souscription" ,
        description ="Supprime une souscription"
    )
    public boolean deleteSouscription(@PathVariable String id){
        return service.deleteSubscription(id);
    }
    
    
    
    
}
