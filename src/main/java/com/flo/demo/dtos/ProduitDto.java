package com.flo.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import com.flo.demo.entity.Produit;
import com.flo.demo.entity.Souscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDto {
    
    private String id;
    private String nom;
    private String description;
    private Long montant;
    private List<SouscriptionDto> souscriptionsDtos;


    public ProduitDto(Produit p){
        this.id = p.getId();
        this.nom = p.getNom();
        this.description = p.getDescription();
        this.montant = p.getMontant();

        this.souscriptionsDtos = new ArrayList<>();
    }


    public void setSouscriptionDto(List<Souscription> souscriptions){

    souscriptions.forEach(s->{
        SouscriptionDto sDto = new SouscriptionDto(s);
        // sDto.setProduitDto(s.getProduit());
        sDto.setUserDto(s.getUser());
        this.souscriptionsDtos.add(sDto);
    });
    }

}
