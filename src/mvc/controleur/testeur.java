package mvc.controleur;

import mvc.modele.*;
import dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        // Tests pour les adresses
        System.out.println("\n=== Tests pour les adresses ===");
        daoAdresse adresseDao = new daoAdresse(dao);
        testAdresse(adresseDao);

        // Tests pour les commentaires
        System.out.println("\n=== Tests pour les commentaires ===");
        daoCommentaire commentaireDao = new daoCommentaire(dao);
        testCommentaire(commentaireDao);

        // Tests pour les options
        System.out.println("\n=== Tests pour les options ===");
        daoOptions optionsDao = new daoOptions(dao);
        testOptions(optionsDao);

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
        Logement logement = new Logement(0, "Appartement Paris", 100, "Bel appartement", "photo1.jpg", 1, 1, 1, "VilleDefault");
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

    private static void testAdresse(daoAdresse adresseDao) {
        // Ajouter une adresse
        Adresse adresse = new Adresse(0, "12", "Rue de la Paix", "75001", "Paris", "France", "Apt 4B", "48.8566, 2.3522");
        int adresseId = adresseDao.ajouter(adresse);
        System.out.println("Adresse ajoutée avec ID : " + adresseId);

        // Chercher une adresse
        Adresse adresseRecherche = adresseDao.chercher(adresseId);
        System.out.println("Adresse recherchée : ");
        adresseDao.afficher(adresseRecherche);

        // Modifier une adresse
        adresseRecherche.setNumero("15");
        adresseRecherche.setComplementAdresse("2ème étage");
        Adresse adresseModifiee = adresseDao.modifier(adresseRecherche);
        System.out.println("Adresse modifiée : ");
        adresseDao.afficher(adresseModifiee);

        // Supprimer une adresse
        adresseDao.supprimer(adresseModifiee);
        System.out.println("Adresse supprimée.");
    }

    private static void testCommentaire(daoCommentaire commentaireDao) {
        // Ajouter un commentaire
        Commentaire commentaire = new Commentaire(0, 1, 1, 5, "Super logement, très propre !", new java.util.Date());
        int commentaireId = commentaireDao.ajouter(commentaire);
        System.out.println("Commentaire ajouté avec ID : " + commentaireId);

        // Chercher un commentaire
        Commentaire commentaireRecherche = commentaireDao.chercher(commentaireId);
        System.out.println("Commentaire recherché : ");
        commentaireDao.afficher(commentaireRecherche);

        // Modifier un commentaire
        commentaireRecherche.setNote(4);
        commentaireRecherche.setCommentaire("Logement propre mais un peu bruyant.");
        Commentaire commentaireModifie = commentaireDao.modifier(commentaireRecherche);
        System.out.println("Commentaire modifié : ");
        commentaireDao.afficher(commentaireModifie);

        // Supprimer un commentaire
        commentaireDao.supprimer(commentaireModifie);
        System.out.println("Commentaire supprimé.");
    }

    public static void testOptions(daoOptions optionsDao) {
        try {
            // Ajouter des options communes
            int optionsId = optionsDao.ajouterOptionsCommunes(
                    true, // Wifi
                    true, // Climatisation
                    "Parking privé", // Parking
                    true, // Vue
                    4, // Nb_personnes
                    1.5f, // Distance_centre_ville
                    10.0f, // Distance_aeroport
                    true // Service_menage
            );
            System.out.println("Options communes ajoutées avec ID : " + optionsId);

            // Ajouter des options spécifiques pour un hôtel
            optionsDao.ajouterOptionsHotel(
                    optionsId,
                    true, // Petit_dejeuner
                    true, // Bar
                    true, // Salle_de_sport
                    true, // Service_etage
                    5 // Nb_etoiles
            );
            System.out.println("Options spécifiques pour hôtel ajoutées.");

            // Ajouter des options spécifiques pour un appartement
            optionsDao.ajouterOptionsAppartement(
                    optionsId,
                    3, // Etage
                    true, // Ascenseur
                    75, // Surface
                    3 // Nb_pieces
            );
            System.out.println("Options spécifiques pour appartement ajoutées.");

            // Ajouter des options spécifiques pour une maison
            optionsDao.ajouterOptionsMaison(
                    optionsId,
                    true, // Jardin
                    true, // Piscine
                    500, // Surface_terrain
                    2 // Nb_etages
            );
            System.out.println("Options spécifiques pour maison ajoutées.");

            // Rechercher les options communes
            var options = optionsDao.chercherOptionsCommunes(optionsId);
            if (!options.isEmpty()) {
                System.out.print("Options communes recherchées :");
                System.out.print(" Wifi : " + options.get(0));
                System.out.print(" Climatisation : " + options.get(1));
                System.out.print(" Parking : " + options.get(2));
                System.out.print(" Vue : " + options.get(3));
                System.out.print(" Nb_personnes : " + options.get(4));
                System.out.print(" Distance_centre_ville : " + options.get(5));
                System.out.print(" Distance_aeroport : " + options.get(6));
                System.out.println("Service_menage : " + options.get(7));
            }

            // Modifier les options communes
            optionsDao.modifierOptionsCommunes(
                    optionsId,
                    false, // Wifi
                    false, // Climatisation
                    "Parking public", // Parking
                    false, // Vue
                    2, // Nb_personnes
                    2.0f, // Distance_centre_ville
                    15.0f, // Distance_aeroport
                    false // Service_menage
            );
            System.out.println("Options communes modifiées.");

            // Modifier les options spécifiques pour un hôtel
            optionsDao.modifierOptionsHotel(
                    optionsId,
                    false, // Petit_dejeuner
                    false, // Bar
                    false, // Salle_de_sport
                    false, // Service_etage
                    3 // Nb_etoiles
            );
            System.out.println("Options spécifiques pour hôtel modifiées.");

            // Modifier les options spécifiques pour un appartement
            optionsDao.modifierOptionsAppartement(
                    optionsId,
                    2, // Etage
                    false, // Ascenseur
                    50, // Surface
                    2 // Nb_pieces
            );
            System.out.println("Options spécifiques pour appartement modifiées.");

            // Modifier les options spécifiques pour une maison
            optionsDao.modifierOptionsMaison(
                    optionsId,
                    false, // Jardin
                    false, // Piscine
                    300, // Surface_terrain
                    1 // Nb_etages
            );
            System.out.println("Options spécifiques pour maison modifiées.");

            // Supprimer les options communes
            optionsDao.supprimerOptionsCommunes(optionsId);
            System.out.println("Options communes supprimées.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}