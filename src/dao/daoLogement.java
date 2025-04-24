package dao;

import MVC.modele.Logement;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation MySQL pour la gestion des logements dans la base de données.
 */
public class daoLogement implements daoInterface<Logement> {
    private daoConnect daoConnect;

    public daoLogement(daoConnect daoConnect) {
        this.daoConnect = daoConnect;
    }

    @Override
    public void afficher(Logement logement) {
        if (logement == null) {
            System.out.println("Logement inexistant");
            return;
        }
        String space = " / ";
        System.out.print("Logement ID : " + logement.getLogementId() + space);
        System.out.print("Nom : " + logement.getNom() + space);
        System.out.print("Adresse : " + logement.getAdresse() + space);
        System.out.print("Coordonnées géographiques : " + logement.getGeoCoord() + space);
        System.out.print("Prix : " + logement.getPrix() + space);
        System.out.print("Description : " + logement.getDescription() + space);
        System.out.print("Liste des photos : " + logement.getListePhotos() + space);
        System.out.println("Propriétaire ID : " + logement.getProprioId());
    }

    @Override
    public ArrayList<Logement> getAll() {
        ArrayList<Logement> logements = new ArrayList<>();
        try (Connection connexion = daoConnect.getConnection();
             Statement statement = connexion.createStatement();
             ResultSet resultats = statement.executeQuery("SELECT * FROM LOGEMENT")) {

            while (resultats.next()) {
                Logement logement = new Logement(
                    resultats.getInt("Logement_ID"),
                    resultats.getString("Nom"),
                    null, // Adresse sera récupérée séparément si nécessaire
                    null, // Coordonnées géographiques seront récupérées séparément si nécessaire
                    resultats.getFloat("Prix"),
                    resultats.getString("Description"),
                    resultats.getString("Liste_photos"),
                    resultats.getInt("Proprio_ID")
                );
                logements.add(logement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération des logements.");
        }
        return logements;
    }

    @Override
    public int ajouter(Logement logement) {
        int id = 0;
        String query = "INSERT INTO LOGEMENT (Nom, Prix, Description, Liste_photos, Proprio_ID, Adresse_ID) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connexion = daoConnect.getConnection();
            PreparedStatement preparedStatement = connexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, logement.getNom());
            preparedStatement.setFloat(2, logement.getPrix());
            preparedStatement.setString(3, logement.getDescription());
            preparedStatement.setString(4, logement.getListePhotos());
            preparedStatement.setInt(5, logement.getProprioId());
            preparedStatement.setInt(6, logement.getLogementId()); // Adresse_ID

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'ajout du logement.");
        }
        return id;
    }

    @Override
    public Logement chercher(int id) {
        Logement logement = null;
        String query = "SELECT * FROM LOGEMENT WHERE Logement_ID = ?";
        try (Connection connexion = daoConnect.getConnection();
            PreparedStatement preparedStatement = connexion.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultats = preparedStatement.executeQuery();
            if (resultats.next()) {
                logement = new Logement(
                    resultats.getInt("Logement_ID"),
                    resultats.getString("Nom"),
                    null, // Adresse sera récupérée séparément si nécessaire
                    null, // Coordonnées géographiques seront récupérées séparément si nécessaire
                    resultats.getFloat("Prix"),
                    resultats.getString("Description"),
                    resultats.getString("Liste_photos"),
                    resultats.getInt("Proprio_ID")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la recherche du logement.");
        }
        return logement;
    }

    @Override
    public Logement modifier(Logement logement) {
        String query = "UPDATE LOGEMENT SET Nom = ?, Prix = ?, Description = ?, Liste_photos = ?, Proprio_ID = ?, Adresse_ID = ? WHERE Logement_ID = ?";
        try (Connection connexion = daoConnect.getConnection();
            PreparedStatement preparedStatement = connexion.prepareStatement(query)) {

            preparedStatement.setString(1, logement.getNom());
            preparedStatement.setFloat(2, logement.getPrix());
            preparedStatement.setString(3, logement.getDescription());
            preparedStatement.setString(4, logement.getListePhotos());
            preparedStatement.setInt(5, logement.getProprioId());
            preparedStatement.setInt(6, logement.getLogementId()); // Adresse_ID
            preparedStatement.setInt(7, logement.getLogementId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la modification du logement.");
        }
        return logement;
    }

    @Override
    public Logement supprimer(Logement logement) {
        String query = "DELETE FROM LOGEMENT WHERE Logement_ID = ?";
        try (Connection connexion = daoConnect.getConnection();
            PreparedStatement preparedStatement = connexion.prepareStatement(query)) {

            preparedStatement.setInt(1, logement.getLogementId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la suppression du logement.");
        }
        return logement;
    }

    /**
     * Recherche des logements disponibles dans une ville donnée pour une période spécifique.
     * @param ville La ville où rechercher les logements.
     * @param dateArrivee La date d'arrivée.
     * @param dateDepart La date de départ.
     * @param nbPersonnes Le nombre de personnes.
     * @return Une liste de logements disponibles correspondant aux critères de recherche.
     */
    public List<Logement> rechercher(String ville, LocalDate dateArrivee, LocalDate dateDepart, int nbPersonnes) {
        List <Logement> logements = new ArrayList<>();

        try {
            Connection connexion_dao = daoConnect.getConnection();
            if (ville.equals("")) {
                ville = "%";
            }
            
            String query = 
            "SELECT * FROM LOGEMENT l " +
            "JOIN adresse a ON l.Adresse_ID = a.Adresse_ID " +
            "JOIN logement_general lg ON l.logement_id = lg.Logement_ID " +
            "JOIN options_communes oc ON lg.Logement_ID = oc.Logement_ID " +
            "WHERE a.Ville LIKE ? AND oc.Nb_personnes >= ? " +
            "AND l.Logement_ID NOT IN ( " +
                "SELECT Logement_ID FROM RESERVATION " +
                "WHERE (Date_arrivee <= ? AND Date_depart >= ?) OR (Date_arrivee <= ? AND Date_depart >= ?) " +
            ")";
            PreparedStatement preparedStatement = connexion_dao.prepareStatement(query);
            preparedStatement.setString(1, "%" + ville + "%");
            preparedStatement.setInt(2, nbPersonnes);
            ResultSet resultats = preparedStatement.executeQuery();

            while (resultats.next()) {
                Logement logement = new Logement(
                    resultats.getInt("Logement_ID"),
                    resultats.getString("Nom"),
                    resultats.getString("Adresse"),
                    resultats.getString("GeoCoord"),
                    resultats.getFloat("Prix"),
                    resultats.getString("Description"),
                    resultats.getString("Liste_photos"),
                    resultats.getInt("Proprio_ID")
                );
                logements.add(logement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la recherche de logements disponibles.");
        }
        return logements;
    }


    public int nb_logements() {
        int nb = 0;

        try {
            Connection connexion_dao = daoConnect.getConnection();

            String query =
                    "SELECT COUNT(*) FROM Logement";
            PreparedStatement preparedStatement = connexion_dao.prepareStatement(query);
            ResultSet resultats = preparedStatement.executeQuery();

            resultats.next();
            nb = resultats.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la recherche de logements disponibles.");
        }
        return nb;
    }
}