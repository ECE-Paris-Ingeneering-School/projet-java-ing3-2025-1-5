package dao;

import MVC.modele.Reservation;
import java.sql.*;
import java.util.ArrayList;

public class daoReservation implements daoInterface<Reservation> {
    private daoConnect daoConnect;

    public daoReservation(daoConnect daoConnect) {
        this.daoConnect = daoConnect;
    }

    @Override
    public void afficher(Reservation reservation) {
        if (reservation == null) {
            System.out.println("Réservation inexistante");
            return;
        }
        String space = " / ";
        System.out.print("Réservation ID : " + reservation.getResaId() + space);
        System.out.print("Client ID : " + reservation.getClientId() + space);
        System.out.print("Logement ID : " + reservation.getLogId() + space);
        System.out.print("Date de début : " + reservation.getDateDebut() + space);
        System.out.print("Date de fin : " + reservation.getDateFin() + space);
        System.out.print("Prix total : " + reservation.getPrixTotal() + space);
        System.out.print("Statut de paiement : " + reservation.getStatutPaiement() + space);
        System.out.print("Date de paiement : " + reservation.getDatePaiement() + space);
        System.out.print("Nombre d'adultes : " + reservation.getNbAdultes() + space);
        System.out.println("Nombre d'enfants : " + reservation.getNbEnfants());
    }

    @Override
    public ArrayList<Reservation> getAll() {
        ArrayList<Reservation> listeReservations = new ArrayList<>();

        try {
            Connection connexion = daoConnect.getConnection();
            Statement statement = connexion.createStatement();
            ResultSet résultats = statement.executeQuery("SELECT * FROM reservation");

            while (résultats.next()) {
                int resaId = résultats.getInt(1);
                int clientId = résultats.getInt(2);
                int logId = résultats.getInt(3);
                Date dateDebut = résultats.getDate(4);
                Date dateFin = résultats.getDate(5);
                float prixTotal = résultats.getFloat(6);
                boolean statutPaiement = résultats.getBoolean(7);
                Date datePaiement = résultats.getDate(8);
                int nbAdultes = résultats.getInt(9);
                int nbEnfants = résultats.getInt(10);

                Reservation reservation = new Reservation(resaId, clientId, logId, dateDebut, dateFin, prixTotal, statutPaiement, datePaiement, nbAdultes, nbEnfants);
                listeReservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Création de la liste de réservations impossible");
        }

        return listeReservations;
    }

    @Override
    public int ajouter(Reservation reservation) {
        int id = 0;

        try {
            Connection connexion = daoConnect.getConnection();
            Statement statement = connexion.createStatement();

            int clientId = reservation.getClientId();
            int logId = reservation.getLogId();
            java.sql.Date dateDebut = java.sql.Date.valueOf(reservation.getDateDebut().toString());
            java.sql.Date dateFin = java.sql.Date.valueOf(reservation.getDateFin().toString());
            float prixTotal = reservation.getPrixTotal();
            boolean statutPaiement = reservation.getStatutPaiement();
            java.sql.Date datePaiement = java.sql.Date.valueOf(reservation.getDatePaiement().toString());            int nbAdultes = reservation.getNbAdultes();
            int nbEnfants = reservation.getNbEnfants();

            statement.executeUpdate("INSERT INTO reservation (Client_ID, Log_ID, Date_debut, Date_fin, Prix_total, Statut_paiement, Date_paiement, Nb_adultes, Nb_enfants) VALUES (" + clientId + ", " + logId + ", '" + dateDebut + "', '" + dateFin + "', " + prixTotal + ", " + statutPaiement + ", '" + datePaiement + "', " + nbAdultes + ", " + nbEnfants + ")");

            ResultSet resultats = statement.executeQuery("SELECT Resa_ID FROM reservation WHERE Client_ID=" + clientId + " AND Log_ID=" + logId + " AND Date_debut='" + dateDebut + "'");
            while (resultats.next()) {
                id = resultats.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ajout de la réservation impossible");
        }

        return id;
    }

    @Override
    public Reservation chercher(int id) {
        Reservation reservation = null;

        try {
            Connection connexion = daoConnect.getConnection();
            Statement statement = connexion.createStatement();
            ResultSet resultats = statement.executeQuery("SELECT * FROM reservation WHERE Resa_ID=" + id);

            while (resultats.next()) {
                int resaId = resultats.getInt(1);
                int clientId = resultats.getInt(2);
                int logId = resultats.getInt(3);
                Date dateDebut = resultats.getDate(4);
                Date dateFin = resultats.getDate(5);
                float prixTotal = resultats.getFloat(6);
                boolean statutPaiement = resultats.getBoolean(7);
                Date datePaiement = resultats.getDate(8);
                int nbAdultes = resultats.getInt(9);
                int nbEnfants = resultats.getInt(10);

                reservation = new Reservation(resaId, clientId, logId, dateDebut, dateFin, prixTotal, statutPaiement, datePaiement, nbAdultes, nbEnfants);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Réservation non trouvée dans la base de données");
        }

        return reservation;
    }

    @Override
    public Reservation modifier(Reservation reservation) {
        try {
            Connection connexion = daoConnect.getConnection();
            StringBuilder query = new StringBuilder("UPDATE reservation SET ");
            boolean first = true;

            if (reservation.getDateDebut() != null) {
                query.append("Date_debut = '").append(reservation.getDateDebut()).append("'");
                first = false;
            }
            if (reservation.getDateFin() != null) {
                if (!first) query.append(", ");
                query.append("Date_fin = '").append(reservation.getDateFin()).append("'");
                first = false;
            }
            if (reservation.getPrixTotal() > 0) {
                if (!first) query.append(", ");
                query.append("Prix_total = ").append(reservation.getPrixTotal());
                first = false;
            }
            if (reservation.getDatePaiement() != null) {
                if (!first) query.append(", ");
                query.append("Date_paiement = '").append(reservation.getDatePaiement()).append("'");
                first = false;
            }
            if (reservation.getNbAdultes() > 0) {
                if (!first) query.append(", ");
                query.append("Nb_adultes = ").append(reservation.getNbAdultes());
                first = false;
            }
            if (reservation.getNbEnfants() > 0) {
                if (!first) query.append(", ");
                query.append("Nb_enfants = ").append(reservation.getNbEnfants());
                first = false;
            }

            query.append(" WHERE Resa_ID = ").append(reservation.getResaId());

            Statement statement = connexion.createStatement();
            statement.executeUpdate(query.toString());

            reservation = chercher(reservation.getResaId());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Modification de la réservation impossible");
        }

        return reservation;
    }

    @Override
    public Reservation supprimer(Reservation reservation) {
        try {
            Connection connexion = daoConnect.getConnection();
            Statement statement = connexion.createStatement();
            statement.executeUpdate("DELETE FROM reservation WHERE Resa_ID=" + reservation.getResaId());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Suppression de la réservation impossible");
        }
        return reservation;
    }
}
