package com.example.demo.dao;

import com.example.demo.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByPseudo(String pseudo);

    @Query("SELECT DISTINCT u FROM Utilisateur u LEFT JOIN FETCH u.taches")
    List<Utilisateur> findAllWithTaches();



}
