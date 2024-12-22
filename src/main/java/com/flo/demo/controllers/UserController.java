package com.flo.demo.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flo.demo.dtos.SouscriptionDto;
import com.flo.demo.dtos.UserDto;
import com.flo.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;




@RestController
@RequiredArgsConstructor
@RequestMapping("/user/")
public class UserController {

    private final UserService userService;

   
    @GetMapping("")
    @Operation(
        summary = "Liste de tous les utilisateurs" ,
        description ="Retourne la liste de tous les utilisateurs"
    )
    public List<UserDto> getAllUsers(){
        return userService.getUsers();
    }


    @PostMapping("")
    @Operation(
        summary = "Ajouter un nouvel utilisateur" ,
        description ="Ajoute un nouvel utilisateur"
    )
    public UserDto newUser(@RequestBody UserDto userDto){
        return userService.newUser(userDto);        
    }   

    @GetMapping("{id}")
    @Operation(
        summary = "Recuperer un utilisateur par son id" ,
        description ="Recuperer un utilisateur par son id"
    )
    public UserDto getMethodName(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("{id}/souscription")
    @Operation(
        summary = "Recuperer les souscriptions d'un utilisateur" ,
        description ="Recuperer les souscriptions d'un utilisateur"
    )
    public List<SouscriptionDto> getUseSouscription(@PathVariable String id) {

        UserDto userDto = userService.getUserById(id);
        return userDto.getSouscriptionsDtos();
    }
    

}