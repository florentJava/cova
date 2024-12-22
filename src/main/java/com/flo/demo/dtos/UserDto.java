package com.flo.demo.dtos;


import java.util.ArrayList;
import java.util.List;

import com.flo.demo.entity.Souscription;
import com.flo.demo.entity.UserEntity;
import com.flo.demo.entity.enumType.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    
    private String id;

    private String email;

    private String password;

    private Role role;
    
    private List<SouscriptionDto> souscriptionsDtos; 

    public UserDto(UserEntity us){
        this.id = us.getId();
        this.email = us.getEmail();
        this.password = us.getPassword();
        this.role = us.getRole();
        this.souscriptionsDtos = new ArrayList<>();
    }

    public void setSouscriptionDto(List<Souscription> souscriptions){

        souscriptions.forEach(s->{
            SouscriptionDto sDto = new SouscriptionDto(s);
            sDto.setProduitDto(s.getProduit());
            // sDto.setUserDto(s.getUser());
            this.souscriptionsDtos.add(sDto);
        });
    }

}
