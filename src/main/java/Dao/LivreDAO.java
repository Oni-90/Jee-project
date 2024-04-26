package Dao;

import java.util.List;

import models.Auteur;
import models.Livre;

public interface LivreDAO {
    void ajouterLivre(Livre livre);
//    List<Livre> obtenirLivresParAuteur(Auteur auteur);
	List<Livre> obtenirLivresParAuteur(int auteurId);
}

