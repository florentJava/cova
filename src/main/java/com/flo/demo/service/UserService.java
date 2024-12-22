package com.flo.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flo.demo.dtos.UserDto;
import com.flo.demo.entity.UserEntity;
import com.flo.demo.repository.UserEntityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;



    /*
     * Recuperer un utilisateur dans la BD
     * par son adresse e-mail
     */
    public Optional<UserEntity> getUserByEmail(String email) {

        Optional<UserEntity> opUser =  userEntityRepository.findByEmail(email);

        if(opUser.isPresent()){

            UserEntity user = opUser.get();
            return Optional.of(user);
        }
        return Optional.empty();

    }



    /*
    * Resuperer un utilisateur dans la BD a partir
    * de son ID
    */
    public UserDto getUserById(String id){

        UserEntity user = userEntityRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));

        UserDto userDto = new UserDto(user);
        userDto.setSouscriptionDto(user.getSouscriptions());
        
        return userDto;
    }
    

    /*
     * Avoir la liste de tous les utilisateurs
     */
    public List<UserDto> getUsers(){

        List<UserEntity> users = userEntityRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user ->{

            UserDto userDto = new UserDto(user);
            userDto.setSouscriptionDto(user.getSouscriptions());
    
            userDtos.add(userDto);

        });


        return userDtos;

    }

    /*
     * Creer un nouvel utilisateur
     */
    public UserDto newUser(UserDto userDto){

        PasswordEncoder passwordEncoder = passwordEncoder();


        
        Optional <UserEntity> opUser = userEntityRepository.findByEmail(userDto.getEmail());

        if(!opUser.isEmpty()){
            throw new RuntimeException("Cet email est déjà utilisé");
        }

        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setPassword(  passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());




        user = userEntityRepository.save(user);

        userDto.setId(user.getId());
        return userDto;

    }
    
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
