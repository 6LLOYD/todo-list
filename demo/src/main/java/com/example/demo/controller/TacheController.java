package com.example.demo.controller;

import com.example.demo.dao.TacheDao;
import com.example.demo.models.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class TacheController {

    @Autowired
    private TacheDao tacheDao;

    @GetMapping("/taches/none")
    public List<Tache> getNonValidatedTasksByPriority() {
        return tacheDao.findAllNonValidatedTasksByPriority();
    }

    @PostMapping("/taches/add")
    public ResponseEntity<Tache> create(@RequestBody Tache tache) {

        //on force l'id à null au cas où le client en aurait fourni un
        tache.setId(null);
        tacheDao.save(tache);

        return new ResponseEntity<>(tache, HttpStatus.CREATED);
    }

    @DeleteMapping("/taches/{id}")
    public ResponseEntity<Tache> delete(@PathVariable Integer id) {

        //On vérifie que l'competence existe bien dans la base de donnée
        Optional<Tache> optionalTache = tacheDao.findById(id);

        //si l'competence n'existe pas
        if(optionalTache.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tacheDao.deleteById(id);

        return new ResponseEntity<>(optionalTache.get(), HttpStatus.OK);

    }
}

