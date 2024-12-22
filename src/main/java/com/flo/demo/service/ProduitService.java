package com.flo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flo.demo.dtos.ProduitDto;
import com.flo.demo.entity.Produit;
import com.flo.demo.repository.ProduitRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepo produitRepo;


    /*
     * Recherche un produit dans la bd a partir
     * de son Id et le convertit sous forme de DTO 
     * avent de le renvoyer
     */

    public ProduitDto getById(String id){
        Produit p = produitRepo.findById(id).orElseThrow(() -> new RuntimeException("Produit not found"));

        ProduitDto pDto = new ProduitDto(p);

        pDto.setSouscriptionDto(p.getSouscriptions());

        return pDto;
    }


    /*
     * Creer un nouveau produit
    */
    public ProduitDto newProduct(ProduitDto pDto){

        Produit p = new Produit(pDto);

        p = produitRepo.save(p);
        pDto.setId(p.getId());

        return pDto;
    }


    /*
     * Renvoie tous les produits de la
     * BD au format Dto
     */

     public List<ProduitDto> getAll(){
        
        List<Produit> produit = produitRepo.findAll();
        List<ProduitDto> produitDtos = new ArrayList<>();

        produit.forEach(p ->{

            ProduitDto pDto = new ProduitDto(p);

            pDto.setSouscriptionDto(p.getSouscriptions());

            produitDtos.add(pDto);
        });

        return produitDtos;


    }



    /*
    * update produit
    */
    public boolean  updateProduit(ProduitDto pDto , String id){

        Produit p = produitRepo.findById(id).orElseThrow(()->new RuntimeException("Product id not found"));

        p.setDescription(pDto.getDescription());
        p.setMontant(pDto.getMontant());
        p.setNom(pDto.getNom());

        produitRepo.save(p);

        return true;
    }
        


    /*
     * Supprimer un produit dans la bd
     */

    public boolean deleteById(String id){
        produitRepo.deleteById(id);
        return true;
    } 
}
