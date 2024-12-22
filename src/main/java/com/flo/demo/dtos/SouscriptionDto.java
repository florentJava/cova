package com.flo.demo.dtos;

import java.sql.Date;

import com.flo.demo.entity.Produit;
import com.flo.demo.entity.Souscription;
import com.flo.demo.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SouscriptionDto {
    
    private String id;
    private Date date_soumission;
    private Date debut_couverture;
    private Date fin_couverture;
    private Long montant;
    private ProduitDto produitDto;
    private UserDto userDto;


    public SouscriptionDto(Souscription s){

        this.id = s.getId();
        this.date_soumission = s.getDebut_couverture();
        this.debut_couverture = s.getDebut_couverture();
        this.fin_couverture = s.getFin_couverture();
        this.montant = s.getMontant();
        
    }


    public void setProduitDto(Produit p){
        this.produitDto = new ProduitDto(p);
    }

    public void setUserDto(UserEntity u){
        this.userDto = new UserDto(u);
    }


   

}
