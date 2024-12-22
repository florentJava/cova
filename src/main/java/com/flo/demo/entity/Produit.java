package com.flo.demo.entity;


import java.util.List;
import java.util.UUID;

import com.flo.demo.dtos.ProduitDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Getter
@Setter

@Table(name = "produit")
@Entity
@RequiredArgsConstructor
public class Produit {


    @Id
    private String id;
    
    @Column (name = "nom")
    private String nom;


    @Column (name = "description")
    private String description;

    @Column (name = "montant")
    private Long montant;


    @OneToMany(
        mappedBy = "produit",
        cascade = CascadeType.ALL
            )
    private List<Souscription> souscriptions;


    @PrePersist()
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }


    public Produit(ProduitDto pDto){

        this.id = pDto.getId();
        this.nom = pDto.getNom();
        this.description = pDto.getDescription();
        this.montant =pDto.getMontant();
        
    }

    
}
