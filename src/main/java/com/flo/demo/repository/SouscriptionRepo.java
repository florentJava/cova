package com.flo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flo.demo.entity.Souscription;

@Repository
public interface SouscriptionRepo extends JpaRepository<Souscription, String> {
    
}
