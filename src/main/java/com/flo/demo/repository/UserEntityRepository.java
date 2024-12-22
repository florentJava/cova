package com.flo.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flo.demo.entity.UserEntity;

@Repository
public interface UserEntityRepository  extends JpaRepository<UserEntity, String>{
    
    Optional<UserEntity> findByEmail(String email);
}
