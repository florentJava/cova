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

import com.flo.demo.dtos.ProduitDto;
import com.flo.demo.service.ProduitService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;






@RestController
@RequiredArgsConstructor
@RequestMapping("/produit/")
public class ProduitController {
    
    private final ProduitService pService;


    @GetMapping("")
    @Operation(
        summary = "Liste de tous les produits" ,
        description ="Retourne la liste de tous les produits"
    )
    public List<ProduitDto> getProducts() {
        return pService.getAll();
    }
    
    @PostMapping("")
    @Operation(
        summary = "Ajouter un nouveau produit" ,
        description ="Ajoute un nouveau produit"
    )
    public ProduitDto newProductsDto(@RequestBody ProduitDto pDto) {
        return pService.newProduct(pDto);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Recuperer un produit par son id" ,
        description ="Recuperer un produit par son id"
    )
    public ProduitDto getByProduitDto(@PathVariable String id) {
        return pService.getById(id);
    }
    
    @PutMapping("{id}")
    @Operation(
        summary = "Mettre a jour un produit" ,
        description ="Mettre a jour un produit"
    )
    public boolean  updateProduit(@PathVariable String id, @RequestBody  ProduitDto pDto) {
        //TODO: process PUT request
        
        return pService.updateProduit(pDto, id);
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Supprimer un produit" ,
        description ="Supprimer un produit"
    )
    public boolean deleteProduit(@PathVariable String id){
        return pService.deleteById(id);
    }
    
}
