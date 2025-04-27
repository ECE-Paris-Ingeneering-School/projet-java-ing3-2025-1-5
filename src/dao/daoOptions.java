package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Implémentation MySQL du stockage dans la base de données des méthodes définies dans l'interface daoInterface
 */
public class daoOptions {
    private final daoConnect connect;

    public daoOptions(daoConnect connect) {
        this.connect = connect;
    }

    // Ajouter des options communes
    public int ajouterOptionsCommunes(boolean wifi, boolean climatisation, String parking, boolean vue, int nbPersonnes, float distanceCentreVille, float distanceAeroport, boolean serviceMenage) {
        String query = "INSERT INTO OPTIONS_COMMUNES (Wifi, Climatisation, Parking, Vue, Nb_personnes, Distance_centre_ville, Distance_aeroport, Service_menage) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setBoolean(1, wifi);
            preparedStatement.setBoolean(2, climatisation);
            preparedStatement.setString(3, parking);
            preparedStatement.setBoolean(4, vue);
            preparedStatement.setInt(5, nbPersonnes);
            preparedStatement.setFloat(6, distanceCentreVille);
            preparedStatement.setFloat(7, distanceAeroport);
            preparedStatement.setBoolean(8, serviceMenage);

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Ajouter des options spécifiques pour un hôtel
    public void ajouterOptionsHotel(int optionsId, boolean petitDejeuner, boolean bar, boolean salleDeSport, boolean serviceEtage, int nbEtoiles) {
        String query = "INSERT INTO OPTIONS_HOTEL (Options_ID, Petit_dejeuner, Bar, Salle_de_sport, Service_etage, Nb_etoiles) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, optionsId);
            preparedStatement.setBoolean(2, petitDejeuner);
            preparedStatement.setBoolean(3, bar);
            preparedStatement.setBoolean(4, salleDeSport);
            preparedStatement.setBoolean(5, serviceEtage);
            preparedStatement.setInt(6, nbEtoiles);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ajouter des options spécifiques pour un appartement
    public void ajouterOptionsAppartement(int optionsId, int etage, boolean ascenseur, int surface, int nbPieces) {
        String query = "INSERT INTO OPTIONS_APPARTEMENT (Options_ID, Etage, Ascenseur, Surface, Nb_pieces) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, optionsId);
            preparedStatement.setInt(2, etage);
            preparedStatement.setBoolean(3, ascenseur);
            preparedStatement.setInt(4, surface);
            preparedStatement.setInt(5, nbPieces);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ajouter des options spécifiques pour une maison
    public void ajouterOptionsMaison(int optionsId, boolean jardin, boolean piscine, int surfaceTerrain, int nbEtages) {
        String query = "INSERT INTO OPTIONS_MAISON (Options_ID, Jardin, Piscine, Surface_terrain, Nb_etages) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, optionsId);
            preparedStatement.setBoolean(2, jardin);
            preparedStatement.setBoolean(3, piscine);
            preparedStatement.setInt(4, surfaceTerrain);
            preparedStatement.setInt(5, nbEtages);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Rechercher des options communes par ID
    public List<Object> chercherOptionsCommunes(int optionsId) {
        String query = "SELECT * FROM OPTIONS_COMMUNES WHERE Options_ID = ?";
        List<Object> options = new ArrayList<>();
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, optionsId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    options.add(resultSet.getBoolean("Wifi"));
                    options.add(resultSet.getBoolean("Climatisation"));
                    options.add(resultSet.getString("Parking"));
                    options.add(resultSet.getBoolean("Vue"));
                    options.add(resultSet.getInt("Nb_personnes"));
                    options.add(resultSet.getFloat("Distance_centre_ville"));
                    options.add(resultSet.getFloat("Distance_aeroport"));
                    options.add(resultSet.getBoolean("Service_menage"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return options;
    }

    // Modifier des options communes
    public void modifierOptionsCommunes(int optionsId, boolean wifi, boolean climatisation, String parking, boolean vue, int nbPersonnes, float distanceCentreVille, float distanceAeroport, boolean serviceMenage) {
        String query = "UPDATE OPTIONS_COMMUNES SET Wifi = ?, Climatisation = ?, Parking = ?, Vue = ?, Nb_personnes = ?, Distance_centre_ville = ?, Distance_aeroport = ?, Service_menage = ? WHERE Options_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setBoolean(1, wifi);
            preparedStatement.setBoolean(2, climatisation);
            preparedStatement.setString(3, parking);
            preparedStatement.setBoolean(4, vue);
            preparedStatement.setInt(5, nbPersonnes);
            preparedStatement.setFloat(6, distanceCentreVille);
            preparedStatement.setFloat(7, distanceAeroport);
            preparedStatement.setBoolean(8, serviceMenage);
            preparedStatement.setInt(9, optionsId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Modifier des options spécifiques pour un hôtel
    public void modifierOptionsHotel(int optionsId, boolean petitDejeuner, boolean bar, boolean salleDeSport, boolean serviceEtage, int nbEtoiles) {
        String query = "UPDATE OPTIONS_HOTEL SET Petit_dejeuner = ?, Bar = ?, Salle_de_sport = ?, Service_etage = ?, Nb_etoiles = ? WHERE Options_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setBoolean(1, petitDejeuner);
            preparedStatement.setBoolean(2, bar);
            preparedStatement.setBoolean(3, salleDeSport);
            preparedStatement.setBoolean(4, serviceEtage);
            preparedStatement.setInt(5, nbEtoiles);
            preparedStatement.setInt(6, optionsId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Modifier des options spécifiques pour un appartement
    public void modifierOptionsAppartement(int optionsId, int etage, boolean ascenseur, int surface, int nbPieces) {
        String query = "UPDATE OPTIONS_APPARTEMENT SET Etage = ?, Ascenseur = ?, Surface = ?, Nb_pieces = ? WHERE Options_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, etage);
            preparedStatement.setBoolean(2, ascenseur);
            preparedStatement.setInt(3, surface);
            preparedStatement.setInt(4, nbPieces);
            preparedStatement.setInt(5, optionsId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Modifier des options spécifiques pour une maison
    public void modifierOptionsMaison(int optionsId, boolean jardin, boolean piscine, int surfaceTerrain, int nbEtages) {
        String query = "UPDATE OPTIONS_MAISON SET Jardin = ?, Piscine = ?, Surface_terrain = ?, Nb_etages = ? WHERE Options_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setBoolean(1, jardin);
            preparedStatement.setBoolean(2, piscine);
            preparedStatement.setInt(3, surfaceTerrain);
            preparedStatement.setInt(4, nbEtages);
            preparedStatement.setInt(5, optionsId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer des options communes
    public void supprimerOptionsCommunes(int optionsId) {
        String query = "DELETE FROM OPTIONS_COMMUNES WHERE Options_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, optionsId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

