package dao;

import MVC.modele.Adresse;

import java.sql.*;
import java.util.ArrayList;

public class daoAdresse implements daoInterface<Adresse> {
    private final daoConnect connect;

    public daoAdresse(daoConnect connect) {
        this.connect = connect;
    }

    @Override
    public void afficher(Adresse adresse) {
        System.out.print("Adresse ID : " + adresse.getAdresseId());
        System.out.print(" Numéro : " + adresse.getNumero());
        System.out.print(" Rue : " + adresse.getRue());
        System.out.print(" Code postal : " + adresse.getCodePostal());
        System.out.print(" Ville : " + adresse.getVille());
        System.out.print(" Pays : " + adresse.getPays());
        System.out.print(" Complément d'adresse : " + adresse.getComplementAdresse());
        System.out.println(" Coordonnées géographiques : " + adresse.getGeoCoord());
    }

    @Override
    public ArrayList<Adresse> getAll() {
        ArrayList<Adresse> adresses = new ArrayList<>();
        String query = "SELECT * FROM ADRESSE";

        try (Connection connection = connect.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Adresse adresse = new Adresse(
                    resultSet.getInt("Adresse_ID"),
                    resultSet.getString("Numero"),
                    resultSet.getString("Rue"),
                    resultSet.getString("Code_postal"),
                    resultSet.getString("Ville"),
                    resultSet.getString("Pays"),
                    resultSet.getString("Complement_adresse"),
                    resultSet.getString("Geo_coord")
                );
                adresses.add(adresse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adresses;
    }

    @Override
    public int ajouter(Adresse adresse) {
        String query = "INSERT INTO ADRESSE (Numero, Rue, Code_postal, Ville, Pays, Complement_adresse, Geo_coord) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, adresse.getNumero());
            preparedStatement.setString(2, adresse.getRue());
            preparedStatement.setString(3, adresse.getCodePostal());
            preparedStatement.setString(4, adresse.getVille());
            preparedStatement.setString(5, adresse.getPays());
            preparedStatement.setString(6, adresse.getComplementAdresse());
            preparedStatement.setString(7, adresse.getGeoCoord());

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

    @Override
    public Adresse chercher(int id) {
        String query = "SELECT * FROM ADRESSE WHERE Adresse_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Adresse(
                    resultSet.getInt("Adresse_ID"),
                    resultSet.getString("Numero"),
                    resultSet.getString("Rue"),
                    resultSet.getString("Code_postal"),
                    resultSet.getString("Ville"),
                    resultSet.getString("Pays"),
                    resultSet.getString("Complement_adresse"),
                    resultSet.getString("Geo_coord")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Adresse modifier(Adresse adresse) {
        String query = "UPDATE ADRESSE SET Numero = ?, Rue = ?, Code_postal = ?, Ville = ?, Pays = ?, Complement_adresse = ?, Geo_coord = ? WHERE Adresse_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, adresse.getNumero());
            preparedStatement.setString(2, adresse.getRue());
            preparedStatement.setString(3, adresse.getCodePostal());
            preparedStatement.setString(4, adresse.getVille());
            preparedStatement.setString(5, adresse.getPays());
            preparedStatement.setString(6, adresse.getComplementAdresse());
            preparedStatement.setString(7, adresse.getGeoCoord());
            preparedStatement.setInt(8, adresse.getAdresseId());

            preparedStatement.executeUpdate();
            return adresse;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Adresse supprimer(Adresse adresse) {
        String query = "DELETE FROM ADRESSE WHERE Adresse_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, adresse.getAdresseId());
            preparedStatement.executeUpdate();
            return adresse;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // source : https://stackoverflow.com/questions/13662984/creating-pie-charts-programmatically
    //on réalise une pie chart pondéré
    public ArrayList<String> getPaysLocation(){ // provenance (pays) des locations du propriétaire
        ArrayList<String> ListePays = new ArrayList<>();
        String query = "SELECT Pays FROM ADRESSE";

        try (Connection connection = connect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                ListePays.add(resultSet.getString("Pays"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ListePays;
    }
}