package com.example.demo.controller;

import com.example.demo.dao.UtilisateurDao;
import com.example.demo.models.Priorite;
import com.example.demo.models.Utilisateur;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurDao utilisateurDao;

    //@Autowired
    //BCryptPasswordEncoder encoder;

    //@IsUser
    @GetMapping("/utilisateur")
    public List<Utilisateur> getAll() {

        return utilisateurDao.findAll();

    }

    //@IsUser
    @GetMapping("/utilisateur/{id}")

    public ResponseEntity<Utilisateur> get(@PathVariable Integer id) {

        //On vérifie que l'utilisateur existe bien dans la base de donnée
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);

        //si l'utilisateur n'existe pas
        if(optionalUtilisateur.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

       return new ResponseEntity<>(optionalUtilisateur.get(),HttpStatus.OK);
    }



}
