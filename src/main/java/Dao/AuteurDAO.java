package Dao;

import java.util.List;

import models.Auteur;

public interface AuteurDAO {
    void ajouterAuteur(Auteur auteur);
    List<Auteur> obtenirTousAuteurs();
}
