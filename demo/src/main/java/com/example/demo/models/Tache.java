package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String description;

    String nom;

    Boolean valide;

    @ManyToOne(cascade = CascadeType.ALL) // Many-to-one relationship to Priorite
    @JoinColumn(name = "priorite_id") // Define join column explicitly
    private Priorite priorite;

   // @ManyToMany(mappedBy = "taches") // Bidirectional Many-to-Many
  //  private List<Utilisateur> utilisateurs = new ArrayList<>();

}
