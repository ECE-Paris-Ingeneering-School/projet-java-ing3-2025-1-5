package dao;

import MVC.modele.Commentaire;
import java.sql.*;
import java.util.ArrayList;

public class daoCommentaire implements daoInterface<Commentaire> {
    private final daoConnect connect;

    public daoCommentaire(daoConnect connect) {
        this.connect = connect;
    }

    @Override
    public void afficher(Commentaire commentaire) {
        System.out.print("Commentaire ID : " + commentaire.getCommentaireId());
        System.out.print(" Client ID : " + commentaire.getClientId());
        System.out.print(" Logement ID : " + commentaire.getLogId());
        System.out.print(" Note : " + commentaire.getNote());
        System.out.print(" Commentaire : " + commentaire.getCommentaire());
        System.out.println(" Date du commentaire : " + commentaire.getDateCommentaire());
    }

    @Override
    public ArrayList<Commentaire> getAll() {
        ArrayList<Commentaire> commentaires = new ArrayList<>();
        String query = "SELECT * FROM COMMENTAIRE";

        try (Connection connection = connect.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Commentaire commentaire = new Commentaire(
                    resultSet.getInt("Commentaire_ID"),
                    resultSet.getInt("Client_ID"),
                    resultSet.getInt("Log_ID"),
                    resultSet.getInt("Note"),
                    resultSet.getString("Commentaire"),
                    resultSet.getDate("Date_commentaire")
                );
                commentaires.add(commentaire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaires;
    }

    @Override
    public int ajouter(Commentaire commentaire) {
        String query = "INSERT INTO COMMENTAIRE (Client_ID, Log_ID, Note, Commentaire, Date_commentaire) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, commentaire.getClientId());
            preparedStatement.setInt(2, commentaire.getLogId());
            preparedStatement.setInt(3, commentaire.getNote());
            preparedStatement.setString(4, commentaire.getCommentaire());
            preparedStatement.setDate(5, new java.sql.Date(commentaire.getDateCommentaire().getTime()));

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
    public Commentaire chercher(int id) {
        String query = "SELECT * FROM COMMENTAIRE WHERE Commentaire_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Commentaire(
                    resultSet.getInt("Commentaire_ID"),
                    resultSet.getInt("Client_ID"),
                    resultSet.getInt("Log_ID"),
                    resultSet.getInt("Note"),
                    resultSet.getString("Commentaire"),
                    resultSet.getDate("Date_commentaire")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Commentaire modifier(Commentaire commentaire) {
        String query = "UPDATE COMMENTAIRE SET Client_ID = ?, Log_ID = ?, Note = ?, Commentaire = ?, Date_commentaire = ? WHERE Commentaire_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, commentaire.getClientId());
            preparedStatement.setInt(2, commentaire.getLogId());
            preparedStatement.setInt(3, commentaire.getNote());
            preparedStatement.setString(4, commentaire.getCommentaire());
            preparedStatement.setDate(5, new java.sql.Date(commentaire.getDateCommentaire().getTime()));
            preparedStatement.setInt(6, commentaire.getCommentaireId());

            preparedStatement.executeUpdate();
            return commentaire;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Commentaire supprimer(Commentaire commentaire) {
        String query = "DELETE FROM COMMENTAIRE WHERE Commentaire_ID = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, commentaire.getCommentaireId());
            preparedStatement.executeUpdate();
            return commentaire;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Commentaire> getCommentairesByClientId(int clientId) {
        ArrayList<Commentaire> commentaires = new ArrayList<>();
        String query = "SELECT * FROM COMMENTAIRE WHERE Client_ID = ? ORDER BY Date_commentaire DESC";
    
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    
            preparedStatement.setInt(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                int commentaireId = resultSet.getInt("Commentaire_ID");
                int logId = resultSet.getInt("Log_ID");
                int note = resultSet.getInt("Note");
                String commentaire = resultSet.getString("Commentaire");
                Date dateCommentaire = resultSet.getDate("Date_commentaire");
    
                commentaires.add(new Commentaire(commentaireId, clientId, logId, note, commentaire, dateCommentaire));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return commentaires;
    }
}