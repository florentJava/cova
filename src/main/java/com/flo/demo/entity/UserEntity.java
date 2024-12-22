package com.flo.demo.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flo.demo.entity.enumType.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Table(name = "dbuser")
@Entity
@RequiredArgsConstructor
public class UserEntity {

    @Id
    private String id;

    @Column (name = "username")
    private String email;

    @JsonIgnore
    @Column (name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    

    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true

    )
    private List<Souscription> souscriptions;



    @PrePersist()
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }  

    
}
