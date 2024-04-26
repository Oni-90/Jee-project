package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Auteur;

public class AuteurDAOImpl implements AuteurDAO {
    private Connection con; 

    
    public AuteurDAOImpl(Connection con) {
        this.con = ConnectDbDao.getCon();
    }

    

	@Override
    public void ajouterAuteur(Auteur auteur) {
        try {
            
            String query = "INSERT INTO auteurs (nom) VALUES (?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, auteur.getNom());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    @Override
    public List<Auteur> obtenirTousAuteurs() {
        List<Auteur> auteurs = new ArrayList<>();

        try {
          
            String query = "SELECT * FROM auteurs";
            try (PreparedStatement preparedStatement = con.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
            	
                while (resultSet.next()) {
                    Auteur auteur = new Auteur();
                    auteur.setId(resultSet.getInt("id"));
                    auteur.setNom(resultSet.getString("nom"));

                  
                    auteurs.add(auteur);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return auteurs;
    }

	public Auteur obtenirAuteurParId(int auteurId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
 
