package com.flo.demo.entity;



import java.sql.Date;
import java.util.UUID;

import com.flo.demo.dtos.SouscriptionDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Table(name = "souscription")
@Entity
@RequiredArgsConstructor
public class Souscription {


    @Id
    private String id;
    
    @Column (name = "date_soumission")
    private Date date_soumission;


    @Column (name = "debut_couverture")
    private Date debut_couverture;

    @Column (name = "fin_couverture")
    private Date fin_couverture;

    @Column(name="montant")
    private Long montant;

    @ManyToOne(        
    )
    @JoinColumn(name="produit_id")
    private Produit produit;

    @ManyToOne(        
    )
    @JoinColumn(name="user_id")
    private UserEntity user;
   

    @PrePersist()
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }


    public Souscription(SouscriptionDto sDto){
        
        this.id = sDto.getId();
        this.date_soumission = sDto.getDebut_couverture();
        this.debut_couverture = sDto.getDebut_couverture();
        this.fin_couverture =sDto.getFin_couverture();
        this.montant = sDto.getMontant();
    }
}
