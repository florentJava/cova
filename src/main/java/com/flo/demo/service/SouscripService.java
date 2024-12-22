package com.flo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flo.demo.dtos.SouscriptionDto;
import com.flo.demo.entity.Produit;
import com.flo.demo.entity.Souscription;
import com.flo.demo.entity.UserEntity;
import com.flo.demo.repository.ProduitRepo;
import com.flo.demo.repository.SouscriptionRepo;
import com.flo.demo.repository.UserEntityRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class SouscripService {

    private final SouscriptionRepo souscripRepo;
    private final ProduitRepo produitRepo;
    private final UserEntityRepository usRepo;
    


    /*
     * Avoir une souscription par son Id
     */
    public SouscriptionDto getById(String id){

        Souscription s = souscripRepo.findById(id).orElseThrow(()-> new RuntimeException("Id non trouver"));

        SouscriptionDto sDto = new SouscriptionDto(s);
        sDto.setUserDto(s.getUser());
        sDto.setProduitDto(s.getProduit());
        


        return sDto;
    }


    /*
     * Creer une souscription
     */
    public SouscriptionDto create(SouscriptionDto sDto){

        Produit p = produitRepo.findById(sDto.getProduitDto().getId())
                        .orElseThrow(()-> new RuntimeException("id produit not fount"));

        UserEntity us = usRepo.findById(sDto.getUserDto().getId())
                        .orElseThrow(()-> new RuntimeException("id user not found"));


        Souscription  s = new Souscription(sDto);

        s = souscripRepo.save(s);

        s.setProduit(p);
        s.setUser(us);

        s = souscripRepo.save(s);


        sDto = new SouscriptionDto(s);
        sDto.setProduitDto(s.getProduit());
        sDto.setUserDto(s.getUser());

        return sDto;


    }


    /*
     * Avoir la liste des souscription
     */

     public List<SouscriptionDto> getAll(){

        List<Souscription> souscriptions = souscripRepo.findAll();
        List<SouscriptionDto> souscriptionDtos = new ArrayList<>();

        

        souscriptions.forEach((s)->{

            SouscriptionDto sDtos = new SouscriptionDto(s);
            sDtos.setProduitDto(s.getProduit());
            sDtos.setUserDto(s.getUser());

            souscriptionDtos.add(sDtos);

        });


        return souscriptionDtos ;

     }


     /*
      * Update souscription
      */

      public boolean update(SouscriptionDto sDto , String id){

        Souscription s = souscripRepo.findById(id).orElseThrow(()->new RuntimeException("Souscription not found"));

        s.setDate_soumission(sDto.getDate_soumission());
        s.setDebut_couverture(sDto.getDebut_couverture());
        s.setFin_couverture(sDto.getFin_couverture());
        s.setMontant(sDto.getMontant());

        souscripRepo.save(s);
        return true;
      }


     /*
      * supprimer une souscription
      */

      public boolean deleteSubscription(String id){
        souscripRepo.deleteById(id);
        return true;
      }




      
    
}
