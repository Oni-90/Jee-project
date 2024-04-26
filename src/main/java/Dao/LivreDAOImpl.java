package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Auteur;
import models.Livre;

public class LivreDAOImpl implements LivreDAO {
    private Connection con; 

   
    public LivreDAOImpl(Connection connection) {
        this.con = ConnectDbDao.getCon();
    }

    @Override
    public void ajouterLivre(Livre livre) {
        try {
            
            String query = "INSERT INTO livres (titre, auteur_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, livre.getTitre());
                preparedStatement.setInt(2, livre.getAuteur().getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public List<Livre> obtenirLivresParAuteur(int auteurId) {
        List<Livre> livres = new ArrayList<>();

        try {
           
            String query = "SELECT * FROM livres WHERE auteur_id = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, auteurId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   
                    while (resultSet.next()) {
                        Livre livre = new Livre();
                        livre.setId(resultSet.getInt("id"));
                        livre.setTitre(resultSet.getString("titre"));

                        
                        livres.add(livre);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return livres;
    }
}
