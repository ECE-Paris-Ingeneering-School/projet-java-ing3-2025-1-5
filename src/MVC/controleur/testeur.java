package MVC.controleur;

import MVC.modele.Client;
import MVC.modele.Logement;
import MVC.modele.Reservation;
import dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class testeur {
    public static void main(String[] args) {
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");

        // Tests pour les clients
        System.out.println("=== Tests pour les clients ===");
        daoClient clientDao = new daoClient(dao);
        testClient(clientDao);

        // Tests pour les logements
        System.out.println("\n=== Tests pour les logements ===");
        daoLogement logementDao = new daoLogement(dao);
        testLogement(logementDao);

        // Tests pour les réservations
        System.out.println("\n=== Tests pour les réservations ===");
        daoReservation reservationDao = new daoReservation(dao);
        testReservation(reservationDao);

        // reset bdd
        System.out.println("\n=== Réinitialisation de la base de données ===");
        dao.resetBDD();
    }

    private static void testClient(daoClient clientDao) {
        // Ajouter un client
        Random rand = new Random();
        int id = rand.nextInt(1000);
        Client client = new Client(0, "Jean", "jean" + id + "@mail.com", "123456", "secure", false, false);
        int clientId = clientDao.ajouter(client);
        System.out.println("Client ajouté avec ID : " + clientId);

        // Chercher un client
        Client clientRecherche = clientDao.chercher(clientId);
        System.out.println("Client recherché : ");
        clientDao.afficher(clientRecherche);

        // Modifier un client
        clientRecherche.setNom("Jean Modifié");
        clientRecherche.setEmail("jean_modifie@mail.com");
        Client clientModifie = clientDao.modifier(clientRecherche);
        System.out.println("Client modifié : ");
        clientDao.afficher(clientModifie);

        // Supprimer un client
        clientDao.supprimer(clientModifie);
        System.out.println("Client supprimé.");
    }

    private static void testLogement(daoLogement logementDao) {
        // Ajouter un logement
        Logement logement = new Logement(0, "Appartement Paris", null, null, 120.5f, "Bel appartement", "photo1.jpg", 1);
        int logementId = logementDao.ajouter(logement);
        System.out.println("Logement ajouté avec ID : " + logementId);

        // Chercher un logement
        Logement logementRecherche = logementDao.chercher(logementId);
        System.out.println("Logement recherché : ");
        logementDao.afficher(logementRecherche);

        // Modifier un logement
        logementRecherche.setNom("Appartement Modifié");
        logementRecherche.setPrix(150.0f);
        Logement logementModifie = logementDao.modifier(logementRecherche);
        System.out.println("Logement modifié : ");
        logementDao.afficher(logementModifie);

        // Supprimer un logement
        logementDao.supprimer(logementModifie);
        System.out.println("Logement supprimé.");
    }

    private static void testReservation(daoReservation reservationDao) {
        try {
            // Format de date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Ajouter une réservation
            Date utilDateDebut = dateFormat.parse("2023-11-12");
            Date utilDateFin = dateFormat.parse("2023-11-20");
            java.sql.Date sqlDateDebut = new java.sql.Date(utilDateDebut.getTime());
            java.sql.Date sqlDateFin = new java.sql.Date(utilDateFin.getTime());
            Reservation reservation = new Reservation(0, 1, 1, sqlDateDebut, sqlDateFin, 500.0f, true, sqlDateDebut, 2, 0);
            int reservationId = reservationDao.ajouter(reservation);
            System.out.println("Réservation ajoutée avec ID : " + reservationId);

            // Chercher une réservation
            Reservation reservationRecherche = reservationDao.chercher(reservationId);
            System.out.println("Réservation recherchée : ");
            reservationDao.afficher(reservationRecherche);

            // Modifier une réservation
            Date utilDateDebutModifie = dateFormat.parse("2023-11-15");
            Date utilDateFinModifie = dateFormat.parse("2023-11-25");
            reservationRecherche.setDateDebut(new java.sql.Date(utilDateDebutModifie.getTime()));
            reservationRecherche.setDateFin(new java.sql.Date(utilDateFinModifie.getTime()));
            Reservation reservationModifiee = reservationDao.modifier(reservationRecherche);
            System.out.println("Réservation modifiée : ");
            reservationDao.afficher(reservationModifiee);

            // Supprimer une réservation
            reservationDao.supprimer(reservationModifiee);
            System.out.println("Réservation supprimée.");
        } catch (ParseException e) {
            System.err.println("Erreur lors du parsing des dates : " + e.getMessage());
        }
    }
}