package com.flo.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.flo.demo.entity.Produit;

@Repository
public interface  ProduitRepo extends JpaRepository<Produit, String>{
    
}
