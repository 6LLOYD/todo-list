package com.example.demo.dao;

import com.example.demo.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TacheDao extends JpaRepository<Tache, Integer> {

    @Query("SELECT t FROM Tache t WHERE t.valide = false ORDER BY t.priorite.id ASC ")
    List<Tache> findAllNonValidatedTasksByPriority();
}
